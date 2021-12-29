package com.example.mvp_rxjava2_dagger_moxy.cicerone
import android.app.Application
import com.example.mvp_rxjava2_dagger_moxy.dagger.ApplicationComponent
import com.example.mvp_rxjava2_dagger_moxy.dagger.DaggerApplicationComponent
import com.example.mvp_rxjava2_dagger_moxy.room.Database

class App : Application() {


    lateinit var component: ApplicationComponent

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }
}