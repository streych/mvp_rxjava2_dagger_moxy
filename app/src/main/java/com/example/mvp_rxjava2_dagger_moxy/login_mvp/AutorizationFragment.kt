package com.example.mvp_rxjava2_dagger_moxy.login_mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_rxjava2_dagger_moxy.cicerone.AndroidScreens
import com.example.mvp_rxjava2_dagger_moxy.cicerone.App
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentAutorizationBinding
import com.example.mvp_rxjava2_dagger_moxy.login_mvp.interfaces.AutorizationView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class AutorizationFragment : MvpAppCompatFragment(), AutorizationView {

    companion object {
        fun newInstance() = AutorizationFragment()
    }

    private val presenter by moxyPresenter {
        AutorizationPresenter(App.instance.router, AndroidScreens())
    }
    private var _binding: FragmentAutorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        binding.btnCheckIn.setOnClickListener {
            presenter.checkPass(
                binding.txtLogin.text.toString(),
                binding.txtPassword.text.toString()
            )
        }
    }

    override fun messageInfo(message: String) {
        view?.let { Snackbar.make(it.rootView, message, Snackbar.LENGTH_LONG).show() }
    }


}