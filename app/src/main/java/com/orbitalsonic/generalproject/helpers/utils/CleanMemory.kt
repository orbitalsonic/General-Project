package com.orbitalsonic.generalproject.helpers.utils

import com.orbitalsonic.generalproject.helpers.firebase.RemoteConstants

object CleanMemory {
    var isActivityRecreated = false
    fun clean() {
        RemoteConstants.reset()
    }

}