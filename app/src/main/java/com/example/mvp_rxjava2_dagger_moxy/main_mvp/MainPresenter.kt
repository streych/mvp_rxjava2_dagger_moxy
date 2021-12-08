package com.example.mvp_rxjava2_dagger_moxy.main_mvp

import com.example.mvp_rxjava2_dagger_moxy.cicerone.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.autorizationFragment())
    }

    fun backClicked() {
        router.exit()
    }
}