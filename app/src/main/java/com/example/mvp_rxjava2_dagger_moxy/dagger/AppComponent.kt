package com.example.mvp_rxjava2_dagger_moxy.dagger

import com.example.mvp_rxjava2_dagger_moxy.mvpmain.MainActivity
import com.example.mvp_rxjava2_dagger_moxy.mvpmain.MainPresenter
import com.example.mvp_rxjava2_dagger_moxy.mvpusers.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        ApiModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)

}