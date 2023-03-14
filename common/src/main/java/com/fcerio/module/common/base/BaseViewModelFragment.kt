package com.fcerio.module.common.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass

/**
 * Base fragment class for fragments that has view models.
 *
 * Automatically initializes ViewDataBinding class and ViewModel class for your fragment.
 */
abstract class BaseViewModelFragment<B : ViewDataBinding, VM : ViewModel> : BaseFragment<B>() {

    protected val viewModel: VM by createViewModelLazy(
        viewModelClass = getViewModelKClass(),
        storeProducer = { getViewModelStoreProducer() }
    )

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelKClass(): KClass<VM> {
        val viewModelClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments.findLast { it is Type } as Class<VM>
        return viewModelClass.kotlin
    }

    private fun getViewModelStoreProducer(): ViewModelStore {
        val owner = when {
            setActivityAsViewModelProvider() -> requireActivity()
            setParentFragmentAsViewModelProvider() -> requireParentFragment()
            else -> this
        }
        return owner.viewModelStore
    }

    open fun setParentFragmentAsViewModelProvider(): Boolean = false

    open fun setActivityAsViewModelProvider(): Boolean = false
}
