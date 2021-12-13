package com.example.mvp_rxjava2_dagger_moxy.cicerone

import com.example.mvp_rxjava2_dagger_moxy.data.Users
import com.example.mvp_rxjava2_dagger_moxy.login_mvp.AutorizationFragment
import com.example.mvp_rxjava2_dagger_moxy.sing_in_mvp.RightPasswordFragment

import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {

    override fun autorizationFragment() = FragmentScreen { AutorizationFragment.newInstance() }
    override fun singInFragment(user: Users) =
        FragmentScreen { RightPasswordFragment.newInstance(user) }
}