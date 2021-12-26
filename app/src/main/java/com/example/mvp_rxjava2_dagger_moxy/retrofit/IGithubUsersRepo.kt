package com.example.mvp_rxjava2_dagger_moxy.retrofit

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getUser(userLogin: String): Single<List<GithubUser>>
}