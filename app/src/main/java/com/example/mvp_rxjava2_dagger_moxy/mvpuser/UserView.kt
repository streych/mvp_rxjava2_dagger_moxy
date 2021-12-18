package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {
    fun getFollowers(id: String, login: String, node: String, html: String)
}
