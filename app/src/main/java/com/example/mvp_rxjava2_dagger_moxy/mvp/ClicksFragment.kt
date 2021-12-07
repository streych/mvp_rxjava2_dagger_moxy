package com.example.mvp_rxjava2_dagger_moxy.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvp_rxjava2_dagger_moxy.mvp.interfaces.MainView
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentClicksBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ClicksFragment : MvpAppCompatFragment(), MainView {

    private val presenter by moxyPresenter {
        Presenter()
    }
    private var _binding: FragmentClicksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClicksBinding.inflate(inflater, container, false)
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

    fun init() {
        binding.apply {
            presenter.apply {
                btnClickOne.setOnClickListener {
                    counterClickOne()
                }
                btnClickTwo.setOnClickListener {
                    counterClickTwo()
                }

                btnClickThree.setOnClickListener {
                    counterClickThree()
                }
            }

        }

    }

    override fun setBtnTextOne(text: String) {
        binding.btnClickTextOne.text = text
    }

    override fun setBtnTextTwo(text: String) {
        binding.btnClickTextTwo.text = text
    }

    override fun setBtnTextThree(text: String) {
        binding.btnClickTextThree.text = text
    }

}