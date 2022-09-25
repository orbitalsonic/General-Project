package com.orbitalsonic.generalproject.ui.fragments.base

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseNavFragment : FragmentGeneral() {

    /**
     *     Used launchWhenCreated, bcz of screen rotation
     *     Used launchWhenResumed, bcz of screen rotation
     * @param fragment_id : Current Fragment's Id (from Nav Graph)
     * @param action : Action / Id of other fragment
     */

    fun navigateTo(fragment_id: Int, action: Int) {
        lifecycleScope.launchWhenCreated {
            if (isAdded && isCurrentDestination(fragment_id)) {
                findNavController().navigate(action)
            }
        }
    }

    fun navigateTo(fragment_id: Int, action: NavDirections) {
        lifecycleScope.launchWhenCreated {
            if (isAdded && isCurrentDestination(fragment_id)) {
                findNavController().navigate(action)
            }
        }
    }

    fun popFrom(fragment_id: Int) {
        lifecycleScope.launchWhenCreated {
            if (isAdded && isCurrentDestination(fragment_id)) {
                findNavController().popBackStack()
            }
        }
    }

    private fun isCurrentDestination(fragment_id: Int): Boolean {
        return findNavController().currentDestination?.id == fragment_id
    }

    fun Fragment.onBackPressed(callback: () -> Unit) {
        this.activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                this.remove()
                callback()
            }
        })
    }
}