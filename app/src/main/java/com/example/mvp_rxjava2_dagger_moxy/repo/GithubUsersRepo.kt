package com.example.mvp_rxjava2_dagger_moxy.repo

import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.model.GithubUser

class GithubUsersRepo {
    private val repository = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): List<GithubUser> = repository
}