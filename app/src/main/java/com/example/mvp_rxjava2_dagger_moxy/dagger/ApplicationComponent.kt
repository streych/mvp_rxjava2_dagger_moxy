package com.example.mvp_rxjava2_dagger_moxy.dagger

import android.content.Context
import com.example.mvp_rxjava2_dagger_moxy.mvpmain.MainActivity
import com.example.mvp_rxjava2_dagger_moxy.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        CiceroneModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)
}