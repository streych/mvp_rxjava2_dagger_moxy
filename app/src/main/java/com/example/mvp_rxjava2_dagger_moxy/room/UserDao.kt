package com.example.mvp_rxjava2_dagger_moxy.room

import androidx.room.*
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser

@Dao
interface UserDao {
    @Query("SELECT * FROM GitHubUserTable")
    fun getAll(): List<GithubUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: GithubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: GithubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<GithubUser>)

    @Update
    fun update(user: GithubUser)

    @Update
    fun update(vararg users: GithubUser)

    @Update
    fun update(users: List<GithubUser>)

    @Query("SELECT * FROM GitHubUserTable WHERE login = :login")
    fun findForUser(login: String): List<GithubUser>

}