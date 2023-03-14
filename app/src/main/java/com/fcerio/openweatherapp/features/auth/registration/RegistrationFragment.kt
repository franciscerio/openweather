package com.fcerio.openweatherapp.features.auth.registration

import android.os.Bundle
import android.view.View
import com.fcerio.module.common.base.BaseFragment
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}