package com.orbitalsonic.generalproject.ui.fragments.base

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withCreated
import androidx.lifecycle.withResumed
import androidx.lifecycle.withStarted
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

abstract class BaseNavFragment : FragmentGeneral() {

    var callback: OnBackPressedCallback? = null

    /**
     *  @since : Write Code for BackPress Functionality
     */
    override fun onResume() {
        super.onResume()
        callback?.remove()
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
                this.remove()
            }
        }.also {
            (context as FragmentActivity).onBackPressedDispatcher.addCallback(this, it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navIconBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    abstract fun navIconBackPressed()
    abstract fun onBackPressed()

    /**
     *     Used launchWhenCreated, bcz of screen rotation
     *     Used launchWhenResumed, bcz of screen rotation
     * @param fragmentId : Current Fragment's Id (from Nav Graph)
     * @param action : Action / Id of other fragment
     * @param bundle : Pass bundle as a NavArgs to destination.
     */

    protected fun navigateTo(fragmentId: Int, action: Int, bundle: Bundle) {
        launchWhenCreated {
            if (isAdded && isCurrentDestination(fragmentId)) {
                findNavController().navigate(action, bundle)
            }
        }
    }

    protected fun navigateTo(fragmentId: Int, action: Int) {
        launchWhenCreated {
            if (isAdded && isCurrentDestination(fragmentId)) {
                findNavController().navigate(action)
            }
        }
    }

    protected fun navigateTo(fragmentId: Int, action: NavDirections) {
        launchWhenCreated {
            if (isAdded && isCurrentDestination(fragmentId)) {
                findNavController().navigate(action)
            }
        }
    }

    protected fun popFrom(fragmentId: Int) {
        launchWhenCreated {
            if (isAdded && isCurrentDestination(fragmentId)) {
                findNavController().popBackStack()
            }
        }
    }

    protected fun popFrom(fragmentId: Int, destinationFragmentId: Int, inclusive: Boolean = false) {
        launchWhenCreated {
            if (isAdded && isCurrentDestination(fragmentId)) {
                findNavController().popBackStack(destinationFragmentId, inclusive)
            }
        }
    }

    private fun isCurrentDestination(fragmentId: Int): Boolean {
        return findNavController().currentDestination?.id == fragmentId
    }

    protected fun launchWhenCreated(callback: () -> Unit) {
        lifecycleScope.launch { lifecycle.withCreated(callback) }
    }

    protected fun launchWhenStarted(callback: () -> Unit) {
        lifecycleScope.launch { lifecycle.withStarted(callback) }
    }

    protected fun launchWhenResumed(callback: () -> Unit) {
        lifecycleScope.launch { lifecycle.withResumed(callback) }
    }
}