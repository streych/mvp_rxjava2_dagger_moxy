package com.example.mvp_rxjava2_dagger_moxy.room

import androidx.room.Room
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App

object RoomFactory {

    private val database: DBStorage by lazy {
        Room.databaseBuilder(
            App.instance.applicationContext,
            DBStorage::class.java,
            "github.db")
            .build()
    }

    fun create(): DBStorage = database
}