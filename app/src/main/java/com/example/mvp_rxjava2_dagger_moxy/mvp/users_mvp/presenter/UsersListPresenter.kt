package com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter

import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.IUserListPresenter
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.UserItemView
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.model.GithubUser

class UsersListPresenter: IUserListPresenter {

    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }

    override fun getCount() = users.size
}