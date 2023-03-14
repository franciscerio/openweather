package com.fcerio.module.common.extensions

import android.os.Environment
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(dest: NavDirections, navigatorExtras: Navigator.Extras? = null) {
    if (navigatorExtras != null) {
        findNavController()
            .navigate(
                dest,
                navigatorExtras
            )
    } else {
        findNavController().navigate(dest)
    }
}

fun Fragment.navigate(dest: NavDirections, navOptions: NavOptions) {
    findNavController()
        .navigate(
            dest,
            navOptions
        )
}

fun Fragment.navigateUp() = findNavController().navigateUp()

fun Fragment.isDestinationInBackstack(@IdRes destinationId: Int): Boolean {
    return try {
        findNavController().getBackStackEntry(destinationId)
        true
    } catch (e: Exception) {
        false
    }
}

fun NavController.getCurrentBackStackEntrySavedStateHandle(): SavedStateHandle? {
    return this.currentBackStackEntry?.savedStateHandle
}
