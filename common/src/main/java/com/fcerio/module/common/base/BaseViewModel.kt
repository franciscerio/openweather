package com.fcerio.module.common.base

import androidx.lifecycle.ViewModel
import com.fcerio.module.common.utils.dispatcher.DispatcherProvider
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var dispatchers: DispatcherProvider
}