package com.orbitalsonic.generalproject.ui.activities.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity() {

    protected val binding by lazy {
        DataBindingUtil.inflate<T>(
            layoutInflater,
            layoutId,
            null,
            false
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}