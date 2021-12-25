package com.example.mvp_rxjava2_dagger_moxy.retrofit

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import com.example.mvp_rxjava2_dagger_moxy.retrofit.api.IDataSource
import com.example.mvp_rxjava2_dagger_moxy.room.RoomFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {

    private val rooDb = RoomFactory.create().getGitHubUserDao()

    override fun getUsers(): Single<List<GithubUser>> {
        return rooDb.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    api.loadUsers()
                        .map { resultFromServer ->
                            rooDb.saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    //    override fun getUsers(): Single<List<GithubUser>> =
//        api.loadUsers().subscribeOn(Schedulers.io())
    override fun getUser(userLogin: String): Single<GithubUser> =
        api.loadUser(userLogin)
}