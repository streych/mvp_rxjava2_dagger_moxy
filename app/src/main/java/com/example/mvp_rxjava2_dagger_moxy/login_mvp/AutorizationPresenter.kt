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

    private fun goToSingIn(user: Users) {
        router.replaceScreen(screens.singInFragment(user))
    }

    fun checkPass(login: String, password: String) {
        if (login.isEmpty() || password.isEmpty()) {
            viewState.messageInfo("Где логин / пароль")
        } else {
           model.isLoginPasswordExist(login, password).subscribe({validate ->
               if (validate) {
                   val user = Users(login, password)
                   goToSingIn(user)
               } else {
                   viewState.messageInfo("Попробуйте снова")
               }
            }, {

            })
        }

    }
}