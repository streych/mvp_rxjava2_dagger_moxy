package com.example.mvp_rxjava2_dagger_moxy

import android.text.Editable
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SqrtView {

    fun getShowNumber(): Editable?
    fun setShowNumber(string: String)
    fun messageInfo()

}