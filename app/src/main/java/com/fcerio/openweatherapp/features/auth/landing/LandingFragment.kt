package com.fcerio.openweatherapp.features.auth.landing

import android.os.Bundle
import android.view.View
import com.fcerio.module.common.base.BaseFragment
import com.fcerio.module.common.extensions.navigate
import com.fcerio.module.common.extensions.ninjaTap
import com.fcerio.module.common.utils.viewLifecycleScope
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentLandingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingFragment : BaseFragment<FragmentLandingBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_landing

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin
            .ninjaTap(viewLifecycleScope) {
                navigate(LandingFragmentDirections.actionLandingFragmentToSignInFragment())
            }

        binding.btnSignup
            .ninjaTap(viewLifecycleScope) {
                navigate(LandingFragmentDirections.actionLandingFragmentToRegistrationFragment())
            }
    }
}