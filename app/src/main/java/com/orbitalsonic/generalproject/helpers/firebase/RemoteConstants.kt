package com.orbitalsonic.generalproject.helpers.firebase

object RemoteConstants {

    /**
     * Remote Config keys
     */

    const val INTER_SPLASH_KEY = "interSplash"
    const val NATIVE_SPLASH_KEY = "nativeSplash"

    /**
     * Constants
     *  -> rcv:  denotes 'remote configuration values'
     *  -> Note
     *         0:   Ads off
     *         1:   Admob Active
     *         2:   Facebook
     */

    var rcvInterSplash: Int = 0
    var rcvNativeSplash: Int = 0


    fun reset() {
        rcvInterSplash = 0
        rcvNativeSplash = 0
    }
}