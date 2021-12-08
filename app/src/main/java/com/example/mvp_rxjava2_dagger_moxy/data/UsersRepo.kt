package com.example.mvp_rxjava2_dagger_moxy.data

class UsersRepo {
    private val users = listOf(
        Users("Atos","1"),
        Users("Patros","2"),
        Users("Parovoz","654321")
    )

    fun getUser(login: String, pass: String): Boolean {
        users.forEach { i ->
            if (i.login == login && i.password == pass) {
                return true
            }
        }
        return false
    }
}