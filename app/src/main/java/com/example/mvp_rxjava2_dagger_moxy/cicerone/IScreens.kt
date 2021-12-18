package com.example.mvp_rxjava2_dagger_moxy.cicerone

import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}