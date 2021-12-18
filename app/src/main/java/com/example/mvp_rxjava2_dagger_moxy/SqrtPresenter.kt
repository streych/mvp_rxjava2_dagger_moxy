package com.example.mvp_rxjava2_dagger_moxy

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import kotlin.math.pow

class SqrtPresenter(): MvpPresenter<SqrtView>() {

    private var model = Model()
    private val behaviorSubject = BehaviorSubject.create<Int>()

    fun getSqrt() {
        viewState.setShowNumber(model.getNumber().toString())
    }

    fun setSqrt() {

        if (viewState.getShowNumber() == null) {
            viewState.messageInfo()
        } else {
            val someInt: Int = viewState.toString().toInt()
            behaviorSubject.subscribeOn(Schedulers.computation())
            behaviorSubject.onNext(someInt)
            behaviorSubject.map {
                model.setNumber(it.toDouble().pow(2).toInt())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        }
    }

}