package com.example.mvp_rxjava2_dagger_moxy

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentSqrtBinding
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment

class SqrtFragment : MvpAppCompatFragment(), SqrtView {
    private var binding: FragmentSqrtBinding? = null
    private val presenter = SqrtPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentSqrtBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.sqrtBtn?.setOnClickListener {

            presenter.setSqrt()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun getShowNumber(): Editable? {
        return binding?.textSqrt?.text
    }

    override fun setShowNumber(string: String) {
        val num = binding?.textSqrt?.text
        if (num.isNullOrEmpty()) {
            messageInfo()
        } else {
            binding?.textSqrt?.text = string.toEditable()
        }
    }

    override fun messageInfo() {
        Snackbar.make(requireView(), getString(R.string.enterNum), Snackbar.LENGTH_LONG).show()
    }

}