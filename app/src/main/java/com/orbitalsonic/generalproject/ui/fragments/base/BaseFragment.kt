package com.orbitalsonic.generalproject.ui.fragments.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.orbitalsonic.generalproject.helpers.koin.DIComponent
import com.orbitalsonic.generalproject.ui.activities.MainActivity

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) : BaseNavFragment() {

    /**
     *     binding & contexts Must be access
     *          -> after onCreateView
     *          -> before onDestroy
     */
    private var _binding: T? = null
    val binding get() = _binding!!

    val globalContext by lazy { binding.root.context }
    val globalActivity by lazy { globalContext as Activity }
    val mainActivity by lazy { globalActivity as MainActivity }

    private var hasInitializedRootView = false
    private var rootView: View? = null

    val diComponent = DIComponent()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        rootView?.let {
            _binding = DataBindingUtil.bind(it)
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
            return it
        } ?: kotlin.run {
            _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            rootView = binding.root
            return rootView!!
        }
    }

    /**
     *      Use the following method in onViewCreated from escaping reinitializing of views
     *      if (!hasInitializedRootView) {
     *          hasInitializedRootView = true
     *          // Your Code...
     *      }
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitializedRootView) {
            hasInitializedRootView = true
            onViewCreatedOneTime()
        }

        onViewCreatedEverytime()
    }

    /**
     *  @since : Write Code to be called onetime
     */
    abstract fun onViewCreatedOneTime()

    /**
     *  @since : Write Code to be called everytime
     */
    abstract fun onViewCreatedEverytime()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        hasInitializedRootView = false
        rootView = null
    }
}