package com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter

import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.IScreens
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.MainView
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.UsersView
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUsersRepo
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val router: Router, val screen: IScreens) : MvpPresenter<UsersView>() {
    private val usersRepo =  GithubUsersRepo()
    val usersListPresenter = UsersListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { userItemView ->

        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}