package com.example.mvp_rxjava2_dagger_moxy.mvp

import com.example.mvp_rxjava2_dagger_moxy.mvp.interfaces.MainView
import moxy.MvpPresenter

class Presenter(): MvpPresenter<MainView>() {

    private val model = Model()

     fun counterClickOne() {
         viewState.setBtnTextOne(nextValue(0).toString())
    }

     fun counterClickTwo() {
         viewState.setBtnTextTwo(nextValue(1).toString())
    }

     fun counterClickThree() {
         viewState.setBtnTextThree(nextValue(2).toString())
    }

    private fun nextValue(index: Int): Int {
        return model.next(index)
    }
}