package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentUserBinding
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import com.example.mvp_rxjava2_dagger_moxy.retrofit.ApiHolder
import com.example.mvp_rxjava2_dagger_moxy.retrofit.RetrofitGithubUsersRepo
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView {
    var binding: FragmentUserBinding? = null
    private val userBundle: GithubUser by lazy {
        arguments?.getParcelable(BUNDLE_USER) ?: GithubUser()
    }

    val presenter by moxyPresenter {
        UserPresenter(userBundle.login.toString(), RetrofitGithubUsersRepo(ApiHolder.api))
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun getFollowers(id: String, login: String, node: String, html: String) {
        binding?.id?.text = id
        binding?.node?.text = node
        binding?.login?.text = login
        binding?.htmlUrl?.text = html
    }

}