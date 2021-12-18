package com.example.mvp_rxjava2_dagger_moxy

class Model {

    private var number: Int = 5

    fun getNumber() = number


    fun setNumber(int: Int) {
            number = int.toString().toInt()
    }

}