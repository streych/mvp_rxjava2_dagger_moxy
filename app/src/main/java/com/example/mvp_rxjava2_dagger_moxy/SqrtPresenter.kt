package com.example.mvp_rxjava2_dagger_moxy

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlin.math.pow

class SqrtPresenter(val view: SqrtView) {

    private var model = Model()

    private fun getSqrt() {
        view.setShowNumber(model.getNumber().toString())
    }

    fun setSqrt() {
        if (view.getShowNumber().isNullOrEmpty()) {
            view.messageInfo()
        } else {
            val someInt: Int = view.getShowNumber().toString().toInt()
            val behaviorSubject = BehaviorSubject.create<Int>()
            behaviorSubject.onNext(someInt)
            behaviorSubject.subscribeOn(Schedulers.io()) //ждем ввода пользователя
            behaviorSubject.observeOn(Schedulers.computation()) //так как возведение в квадрат сложная
            // операция и чем больше число тем больше нагрузка
            behaviorSubject.subscribe({
                model.setNumber(it.toDouble().pow(2).toInt())
                getSqrt()
            }, {

            })
            //баг если пустое значение падает
            Thread.sleep(5000)
        }

    }

}