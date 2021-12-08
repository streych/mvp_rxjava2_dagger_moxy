package com.example.mvp_rxjava2_dagger_moxy.login_mvp.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AutorizationView: MvpView {

    fun messageInfo(message: String)
    fun init()
}
