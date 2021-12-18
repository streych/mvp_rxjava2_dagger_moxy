package com.example.mvp_rxjava2_dagger_moxy.mvpusers

import com.example.mvp_rxjava2_dagger_moxy.interfaces.IUserListPresenter
import com.example.mvp_rxjava2_dagger_moxy.interfaces.UserItemView
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser

class UsersListPresenter: IUserListPresenter {

    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login.toString())
    }

    override fun getCount() = users.size
}