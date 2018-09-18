package com.ing.airquality.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
        crossinline provider: () -> VM) = lazy(mode) {
    ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T1 : ViewModel> create(aClass: Class<T1>) =
                provider() as T1
    }).get(VM::class.java)
}
