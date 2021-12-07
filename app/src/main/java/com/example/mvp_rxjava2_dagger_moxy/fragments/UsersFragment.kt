package com.example.mvp_rxjava2_dagger_moxy.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_rxjava2_dagger_moxy.app.App
import com.example.mvp_rxjava2_dagger_moxy.cicerone.AndroidScreens
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentClicksBinding
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.BackButtonListener
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.UsersView
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.UsersPresenter
import com.example.mvp_rxjava2_dagger_moxy.recycler_adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    val presenter: UsersPresenter by moxyPresenter { UsersPresenter(App.instance.router, AndroidScreens()) }
    private var adapter: UsersRVAdapter? = null
    private var binding: FragmentClicksBinding? = null


    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentClicksBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding?.rvUsers?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}