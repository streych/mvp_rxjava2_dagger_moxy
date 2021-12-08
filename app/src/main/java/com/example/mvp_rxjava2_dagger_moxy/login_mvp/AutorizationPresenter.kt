package com.example.mvp_rxjava2_dagger_moxy.login_mvp

import com.example.mvp_rxjava2_dagger_moxy.cicerone.IScreens
import com.example.mvp_rxjava2_dagger_moxy.data.Users
import com.example.mvp_rxjava2_dagger_moxy.data.UsersRepo
import com.example.mvp_rxjava2_dagger_moxy.login_mvp.interfaces.AutorizationView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class AutorizationPresenter(private val router: Router, private val screens: IScreens) :
    MvpPresenter<AutorizationView>() {

    private val model = UsersRepo()

    private fun goToSingIn(login: Users) {
        router.replaceScreen(screens.singInFragment(login))
    }

    fun checkPass(login: String, password: String) {
        if (login.isEmpty() || password.isEmpty()) {
            viewState.messageInfo("Где логин / пароль")
        } else {
            val unswer = model.getUser(login, password)
            if (unswer) {
                val user = Users(login, password)
                goToSingIn(user)
            } else {
                viewState.messageInfo("Попробуйте снова")
            }
        }

    }
}