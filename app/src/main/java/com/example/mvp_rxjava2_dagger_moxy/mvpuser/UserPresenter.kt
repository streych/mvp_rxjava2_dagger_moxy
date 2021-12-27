package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import com.example.mvp_rxjava2_dagger_moxy.retrofit.IGithubUsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(val userLogin: String, val usersRepos: IGithubUsersRepo) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getFollowers()
    }

    fun getFollowers() {
        // usersRepos.getUser(userLogin).let { return@let viewState::getFollowers }
        usersRepos.getUser(userLogin).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ repo ->
                viewState.getFollowers("0", "0", "0", "0")
            }, {

            })
    }
}