package io.redspark.redstest.modules.viper_plugin.extensions;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.fragment.app.Fragment
import io.redspark.redstest.modules.viper_plugin.utils.ViewModelFactory

inline fun <reified T : ViewModel> Fragment.instantiateAndBindViewModel(noinline factoryBlock: () -> T): T {
    return ViewModelProviders.of(this, ViewModelFactory(factoryBlock))
        .get(T::class.java)
}