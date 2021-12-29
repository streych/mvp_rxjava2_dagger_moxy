package com.example.mvp_rxjava2_dagger_moxy.dagger

import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }
}