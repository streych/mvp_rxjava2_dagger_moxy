package com.example.mvp_rxjava2_dagger_moxy.retrofit

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import com.example.mvp_rxjava2_dagger_moxy.room.Database
import com.example.mvp_rxjava2_dagger_moxy.room.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(
    val api: IDataSource,
    val networkStats: INetworkStatus,
    val db: Database
) : IGithubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> =
        networkStats.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.loadUsers()
                    .flatMap { users ->
                        Single.fromCallable {
                            val roomUsers = users.map { user ->
                                GithubUser(
                                    user.id ?: "",
                                    user.login ?: "",
                                    user.avatarUrl ?: "",
                                    user.node_id ?: "",
                                    user.html_url ?: ""
                                )
                            }
                            db.userDao.insert(roomUsers)
                            users
                        }
                    }
            } else {
                Single.fromCallable {
                    db.userDao.getAll().map { roomUser ->
                        GithubUser(
                            roomUser.id,
                            roomUser.login,
                            roomUser.avatarUrl,
                            roomUser.node_id,
                            roomUser.html_url
                        )
                    }
                }
            }.subscribeOn(Schedulers.io())
        }


    override fun getUser(userLogin: String):  Single<List<GithubUser>> = Single.fromCallable {
        db.userDao.findForUser(userLogin).map { roomUser ->
            GithubUser(
                roomUser.id,
                roomUser.login,
                roomUser.avatarUrl,
                roomUser.node_id,
                roomUser.html_url
            )
        }
    }.subscribeOn(Schedulers.io())
}

