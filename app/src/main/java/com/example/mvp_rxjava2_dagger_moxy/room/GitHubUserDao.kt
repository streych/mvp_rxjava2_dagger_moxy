package com.example.mvp_rxjava2_dagger_moxy.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers(): Single<List<GithubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GithubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<GithubUser>)

    @Insert(onConflict = REPLACE)
    fun saveUser(user: GithubUser)
}
