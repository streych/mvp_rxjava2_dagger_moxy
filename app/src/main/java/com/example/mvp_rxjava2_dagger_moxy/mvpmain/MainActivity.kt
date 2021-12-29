package com.example.mvp_rxjava2_dagger_moxy.mvpmain

import android.os.Bundle
import com.example.mvp_rxjava2_dagger_moxy.R
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import com.example.mvp_rxjava2_dagger_moxy.databinding.ActivityMainBinding
import com.example.mvp_rxjava2_dagger_moxy.interfaces.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {


    private var binding: ActivityMainBinding? = null

    @set:Inject
    var router: Router? = null

    @set:Inject
    var navigatorHolder: NavigatorHolder? = null
    val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.component.inject(this@MainActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        App.instance.component.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder?.removeNavigator()
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