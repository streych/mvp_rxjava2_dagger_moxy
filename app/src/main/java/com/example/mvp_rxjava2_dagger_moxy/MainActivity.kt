package com.example.mvp_rxjava2_dagger_moxy

import android.os.Bundle
import com.example.mvp_rxjava2_dagger_moxy.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        supportFragmentManager.beginTransaction().replace(R.id.container, SqrtFragment()).commit()
    }
}