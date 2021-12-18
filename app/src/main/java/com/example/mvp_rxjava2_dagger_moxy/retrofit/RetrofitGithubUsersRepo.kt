package com.example.mvp_rxjava2_dagger_moxy.retrofit

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {
    override fun getUsers(): Single<List<GithubUser>> = api.loadUsers().subscribeOn(Schedulers.io())
    override fun getUser(userLogin: String): Single<GithubUser> = api.loadUser(userLogin)
}