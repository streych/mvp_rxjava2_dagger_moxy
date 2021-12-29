package com.example.mvp_rxjava2_dagger_moxy.mvpusers

import android.annotation.SuppressLint
import android.os.Bundle
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import com.example.mvp_rxjava2_dagger_moxy.cicerone.AndroidScreens
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentUsersBinding
import com.example.mvp_rxjava2_dagger_moxy.glide.GlideImageLoader
import com.example.mvp_rxjava2_dagger_moxy.interfaces.BackButtonListener
import com.example.mvp_rxjava2_dagger_moxy.retrofit.ApiHolder
import com.example.mvp_rxjava2_dagger_moxy.retrofit.RetrofitGithubUsersRepo
import com.example.mvp_rxjava2_dagger_moxy.room.AndroidNetworkStatus
import com.example.mvp_rxjava2_dagger_moxy.room.Database
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.component.inject(this)
        }
    }

    private var adapter: UsersRVAdapter? = null
    private var binding: FragmentUsersBinding? = null
    @Inject
    var router: Router? = null

    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        binding?.rvUsers?.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}