package com.example.mvp_rxjava2_dagger_moxy.cicerone

import com.example.mvp_rxjava2_dagger_moxy.mvpuser.UserFragment
import com.example.mvp_rxjava2_dagger_moxy.mvpusers.UsersFragment
import com.example.mvp_rxjava2_dagger_moxy.repo.GithubUser
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}