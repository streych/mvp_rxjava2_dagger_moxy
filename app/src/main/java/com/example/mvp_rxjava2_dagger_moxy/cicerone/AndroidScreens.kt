package com.example.mvp_rxjava2_dagger_moxy.cicerone

import com.example.mvp_rxjava2_dagger_moxy.fragments.UsersFragment
import com.example.mvp_rxjava2_dagger_moxy.mvp.users_mvp.presenter.interfaces.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}