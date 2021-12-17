package com.example.mvp_rxjava2_dagger_moxy

import android.text.Editable
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SqrtView: MvpView {

    fun getShowNumber(): Editable?
    fun setShowNumber(string: String)
    fun messageInfo()

}
