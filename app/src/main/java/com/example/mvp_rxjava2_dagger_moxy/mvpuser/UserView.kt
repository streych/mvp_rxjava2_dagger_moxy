package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {
    @SingleState
    fun getFollowers(id: String, login: String, node: String, html: String)
}
