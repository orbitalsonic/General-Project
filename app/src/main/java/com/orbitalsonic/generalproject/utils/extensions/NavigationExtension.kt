package com.orbitalsonic.generalproject.utils.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

/**
 *     Used launchWhenCreated, bcz of screen rotation
 *     Used launchWhenResumed, bcz of screen rotation
 * @param fragmentId : Current Fragment's Id (from Nav Graph)
 * @param action : Action / Id of other fragment
 * @param bundle : Pass bundle as a NavArgs to destination.
 */

fun Fragment.navigateTo(fragmentId: Int, action: Int, bundle: Bundle) {
    launchWhenCreated {
        if (isAdded && isCurrentDestination(fragmentId)) {
            findNavController().navigate(action, bundle)
        }
    }
}

fun Fragment.navigateTo(fragmentId: Int, action: Int) {
    launchWhenCreated {
        if (isAdded && isCurrentDestination(fragmentId)) {
            findNavController().navigate(action)
        }
    }
}

fun Fragment.navigateTo(fragmentId: Int, action: NavDirections) {
    launchWhenCreated {
        if (isAdded && isCurrentDestination(fragmentId)) {
            findNavController().navigate(action)
        }
    }
}

fun Fragment.popFrom(fragmentId: Int) {
    launchWhenCreated {
        if (isAdded && isCurrentDestination(fragmentId)) {
            findNavController().popBackStack()
        }
    }
}

fun Fragment.popFrom(fragmentId: Int, destinationFragmentId: Int, inclusive: Boolean = false) {
    launchWhenCreated {
        if (isAdded && isCurrentDestination(fragmentId)) {
            findNavController().popBackStack(destinationFragmentId, inclusive)
        }
    }
}

fun Fragment.isCurrentDestination(fragmentId: Int): Boolean {
    return findNavController().currentDestination?.id == fragmentId
}