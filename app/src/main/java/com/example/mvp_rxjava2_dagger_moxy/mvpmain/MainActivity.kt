package com.example.mvp_rxjava2_dagger_moxy.mvpmain

import android.os.Bundle
import com.example.mvp_rxjava2_dagger_moxy.R
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import com.example.mvp_rxjava2_dagger_moxy.cicerone.AndroidScreens
import com.example.mvp_rxjava2_dagger_moxy.databinding.ActivityMainBinding
import com.example.mvp_rxjava2_dagger_moxy.interfaces.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {


    private var binding: ActivityMainBinding? = null
    val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }


}