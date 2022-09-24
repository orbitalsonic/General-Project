package com.orbitalsonic.generalproject.helpers.managers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException

class InternetManager(private val context: Context) {

    val isInternetConnected: Boolean
        get() {
            try {
                val connectivityManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val network = connectivityManager.activeNetwork ?: return false
                val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
                return when {
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } catch (ex: Exception) {
                ex.recordException("Internet Manager")
                return false
            }
        }
}