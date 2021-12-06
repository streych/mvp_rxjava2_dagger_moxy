package com.example.mvp_rxjava2_dagger_moxy.mvp

import com.example.mvp_rxjava2_dagger_moxy.mvp.interfaces.MainView

class Presenter(private val mainView: MainView) {

    private val model = Model()

     fun counterClickOne() {
         mainView.setBtnTextOne(nextValue(0).toString())
    }

     fun counterClickTwo() {
         mainView.setBtnTextTwo(nextValue(1).toString())
    }

     fun counterClickThree() {
         mainView.setBtnTextThree(nextValue(2).toString())
    }

    private fun nextValue(index: Int): Int {
        return model.next(index)
    }
}