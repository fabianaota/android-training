package io.redspark.redstest.modules.viper_plugin.utils;

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.redspark.redstest.modules.viper_plugin.errors.ViperModuleAssemblerException
import io.redspark.redstest.modules.viper_plugin.interfaces.ModuleAssembler

abstract class BaseFragment<T, U : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
    private val moduleAssembler: ModuleAssembler
) : Fragment() {

    private var _presenter: T? = null
    internal var presenter: T
        get() = _presenter ?: throw ViperModuleAssemblerException()
        set(value) {
            _presenter = value
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moduleAssembler.assembleModule(this)

        val binding: U = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.setLifecycleOwner(this)
        bind(binding)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onModuleAssembled()
    }

    open fun bind(binding: U) {
        val javaClass = binding::class.java
        val field = javaClass.declaredFields
            .plus(javaClass.superclass.declaredFields)
            .firstOrNull { it.name.contains("presenter", true) }
        field?.isAccessible = true
        field?.set(binding, presenter)
    }

    abstract fun onModuleAssembled()

}