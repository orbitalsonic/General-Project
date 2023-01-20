package com.orbitalsonic.generalproject.helpers.utils

import com.orbitalsonic.generalproject.helpers.firebase.RemoteConstants

object CleanMemory {

    fun clean() {
        RemoteConstants.reset()
    }

}