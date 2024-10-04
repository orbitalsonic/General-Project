package com.orbitalsonic.generalproject.utils.internet

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class InternetManager(private val connectivityManager: ConnectivityManager) {

    /**
     * fetching internet manager in activity or fragment
     * val internetManager = InternetManager(this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager)
     */

    val isInternetConnected: Boolean
        get() {
            try {
                val network = connectivityManager.activeNetwork ?: return false
                val networkCapabilities =
                    connectivityManager.getNetworkCapabilities(network) ?: return false
                return when {
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                    else -> false
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return false
            }
        }

}