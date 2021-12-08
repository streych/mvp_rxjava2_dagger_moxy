package com.example.mvp_rxjava2_dagger_moxy.sing_in_mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvp_rxjava2_dagger_moxy.data.Users
import com.example.mvp_rxjava2_dagger_moxy.databinding.FragmentRightPasswordBinding
import moxy.MvpAppCompatFragment

class RightPasswordFragment : MvpAppCompatFragment() {

    companion object {
        //переменная  для Bundle
        val BUNDLE_EXTRA = "user"
        fun newInstance(bundle: Bundle): RightPasswordFragment {
            val fragment = RightPasswordFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    private var _binding: FragmentRightPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRightPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginBundle: Users = arguments?.getParcelable(BUNDLE_EXTRA) ?: Users()
        binding.loginRP.text = loginBundle.login
    }

}