package com.example.mvp_rxjava2_dagger_moxy.data

import io.reactivex.rxjava3.core.Observable

class UsersRepo {
    private val users = listOf(
        Users("Atos","1"),
        Users("Patros","2"),
        Users("Parovoz","654321")
    )

    fun isLoginPasswordExist(login: String, pass: String): Observable<Boolean> {
        users.forEach { i ->
            if (i.login == login && i.password == pass) {
                return Observable.just(true)
            }
        }
        return Observable.just(false)
    }
}