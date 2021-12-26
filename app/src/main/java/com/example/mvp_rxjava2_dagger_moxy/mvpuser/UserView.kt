package com.example.mvp_rxjava2_dagger_moxy.mvpuser

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {

    @SingleState
    fun getFollowers(user: GithubUser)
}
