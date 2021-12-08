package com.example.mvp_rxjava2_dagger_moxy.cicerone

import android.os.Bundle
import com.example.mvp_rxjava2_dagger_moxy.data.Users
import com.example.mvp_rxjava2_dagger_moxy.login_mvp.AutorizationFragment
import com.example.mvp_rxjava2_dagger_moxy.sing_in_mvp.RightPasswordFragment

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {

    override fun autorizationFragment() = FragmentScreen { AutorizationFragment.newInstance() }
    override fun singInFragment(user: Users): Screen {
        return FragmentScreen {
            RightPasswordFragment.newInstance(Bundle().apply {
               putParcelable(RightPasswordFragment.BUNDLE_EXTRA, user)
            })
        }
    }
}