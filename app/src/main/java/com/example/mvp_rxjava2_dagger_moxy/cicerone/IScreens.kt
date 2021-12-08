package com.example.mvp_rxjava2_dagger_moxy.cicerone

import com.example.mvp_rxjava2_dagger_moxy.data.Users
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun autorizationFragment(): Screen
    fun singInFragment(user: Users): Screen
}