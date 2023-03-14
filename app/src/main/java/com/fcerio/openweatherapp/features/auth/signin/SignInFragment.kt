package com.fcerio.openweatherapp.features.auth.signin

import android.os.Bundle
import android.view.View
import com.fcerio.module.common.base.BaseFragment
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentSigninBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSigninBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_signin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
    }

    private fun setupToolbar() {
//        with(binding.toolbar.toolbarView) {
//
//        }
    }
}