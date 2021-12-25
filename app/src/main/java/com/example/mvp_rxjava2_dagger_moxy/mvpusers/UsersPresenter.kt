package com.example.mvp_rxjava2_dagger_moxy.mvpusers

import com.example.mvp_rxjava2_dagger_moxy.cicerone.IScreens
import com.example.mvp_rxjava2_dagger_moxy.retrofit.IGithubUsersRepo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    val uiScheduler: Scheduler,
    val usersRepos: IGithubUsersRepo,
    val router: Router,
    val screen: IScreens) :
    MvpPresenter<UsersView>() {
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

        usersRepos.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            },
                {
                    println("Error: ${it.message}")
                })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}