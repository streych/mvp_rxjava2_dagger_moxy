package com.example.mvp_rxjava2_dagger_moxy.mvp.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun setBtnTextOne(text: String)
    fun setBtnTextTwo(text: String)
    fun setBtnTextThree(text: String)

}