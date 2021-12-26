package com.example.mvp_rxjava2_dagger_moxy.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser


@androidx.room.Database(entities = [GithubUser::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: Database? = null
        fun getInstance() = instance
            ?: throw RuntimeException("Database has not been created. Please call create(context)")

        fun create(context: Context?) {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, Database::class.java, DB_NAME).build()
            }
        }
    }
}