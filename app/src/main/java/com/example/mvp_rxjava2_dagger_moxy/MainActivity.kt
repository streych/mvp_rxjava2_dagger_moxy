package com.example.mvp_rxjava2_dagger_moxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_rxjava2_dagger_moxy.databinding.ActivityMainBinding
import com.example.mvp_rxjava2_dagger_moxy.fragments.ClicksFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportFragmentManager.beginTransaction().add(R.id.container, ClicksFragment()).commit()
    }

}