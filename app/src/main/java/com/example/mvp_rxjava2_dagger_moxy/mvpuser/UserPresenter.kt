package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import com.example.mvp_rxjava2_dagger_moxy.retrofit.IGithubUsersRepo
import moxy.MvpPresenter

class UserPresenter(val userLogin: String, val usersRepos: IGithubUsersRepo) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getFollowers()
    }

    fun getFollowers() {
        usersRepos.getUser(userLogin).let { return@let viewState::getFollowers }
    }
}