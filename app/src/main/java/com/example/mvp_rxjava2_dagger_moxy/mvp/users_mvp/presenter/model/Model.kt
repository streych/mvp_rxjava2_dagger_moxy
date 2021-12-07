package com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.model

class Model {

    private val clicks = mutableListOf(0, 0, 0)

    private fun getCount(index: Int): Int {
        return clicks[index]
    }

    fun next(index: Int): Int {
        clicks[index]++
        return getCount(index)
    }
}