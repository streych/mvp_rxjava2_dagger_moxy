package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import com.example.mvp_rxjava2_dagger_moxy.cicerone.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(val router: Router, val screen: IScreens) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}