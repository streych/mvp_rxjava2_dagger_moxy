package com.example.mvp_rxjava2_dagger_moxy.retrofit.api

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("users")
    fun loadUsers(): Single<List<GithubUser>>

    @GET("users/{login}")
    fun loadUser(@Path("login") login: String): Single<GithubUser>
}