package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_rxjava2_dagger_moxy.cicerone.AndroidScreens
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentUserBinding
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView {
    var binding: FragmentUserBinding? = null

    val presenter by moxyPresenter {
        UserPresenter(App.instance.router, AndroidScreens())
    }

    companion object {
        const val BUNDLE_USER = "user"
        fun newInstance(user: GithubUser): UserFragment {
            val fragment = UserFragment()
            val arg = Bundle()
            arg.putParcelable(BUNDLE_USER, user)
            fragment.arguments = arg
            return fragment
        }
    }

    private val userBundle: GithubUser by lazy {
        arguments?.getParcelable(BUNDLE_USER) ?: GithubUser()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.login?.text = userBundle.login
    }


}