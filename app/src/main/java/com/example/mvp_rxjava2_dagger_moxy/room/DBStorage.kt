package com.example.mvp_rxjava2_dagger_moxy.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser

@Database(
    exportSchema = false,
    entities = [GithubUser::class],
    version = 1
)
abstract class DBStorage: RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao
}