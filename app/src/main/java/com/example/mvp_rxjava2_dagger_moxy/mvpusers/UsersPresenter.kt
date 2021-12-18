package com.example.mvp_rxjava2_dagger_moxy.mvpusers

import com.example.mvp_rxjava2_dagger_moxy.cicerone.IScreens
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
            val user = usersListPresenter.users[userItemView.pos]
            router.navigateTo(screen.user(user))
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