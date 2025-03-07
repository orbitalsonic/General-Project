package com.orbitalsonic.generalproject.presentation.samples.location

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class LocationViewModel : ViewModel() {

    private val _coordinatesLiveData = MutableLiveData<Location?>()
    val coordinatesLiveData: LiveData<Location?> = _coordinatesLiveData

    private val _addressLiveData = MutableLiveData<String?>()
    val addressLiveData: LiveData<String?> = _addressLiveData

    /**
     * Pair Fist is Location Coordinates
     * Pair Second is Address
     */
    private val _locationLiveData = MutableLiveData<Pair<Location, String>?>()
    val locationLiveData: LiveData<Pair<Location, String>?> = _locationLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    @SuppressLint("MissingPermission")
    fun fetchCoordsAndAddress(context: Context?) {
        try {
            _loadingLiveData.postValue(true)
            context?.let { mContext ->
                val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext)

                fusedLocationProviderClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        location?.let {
                            findAddressForCAA(mContext,it)
                        } ?: run {
                            _loadingLiveData.postValue(false)
                            _locationLiveData.postValue(null)
                        }
                    }
                    .addOnFailureListener {
                        _loadingLiveData.postValue(false)
                        _locationLiveData.postValue(null)
                    }
            }?:run {
                _loadingLiveData.postValue(false)
                _locationLiveData.postValue(null)
            }

        } catch (e: Exception) {
            _loadingLiveData.postValue(false)
            _locationLiveData.postValue(null)
        }
    }

    @SuppressLint("MissingPermission")
    fun fetchCoordinates(context: Context?) {
        try {
            _loadingLiveData.postValue(true)

            context?.let { mContext ->
                val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext)
                fusedLocationProviderClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        _loadingLiveData.postValue(false)
                        _coordinatesLiveData.postValue(location)
                    }
                    .addOnFailureListener {
                        _loadingLiveData.postValue(false)
                        _coordinatesLiveData.postValue(null)
                    }
            }?:run {
                _loadingLiveData.postValue(false)
                _coordinatesLiveData.postValue(null)
            }

        } catch (e: Exception) {
            _loadingLiveData.postValue(false)
            _coordinatesLiveData.postValue(null)
        }
    }

    @SuppressLint("MissingPermission")
    fun fetchAddress(context: Context?) {
        try {
            _loadingLiveData.postValue(true)
            context?.let { mContext ->
                val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext)
                fusedLocationProviderClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        location?.let {
                            findAddress(mContext,it)
                        } ?: run {
                            _loadingLiveData.postValue(false)
                            _addressLiveData.postValue(null)
                        }
                    }
                    .addOnFailureListener {
                        _loadingLiveData.postValue(false)
                        _addressLiveData.postValue(null)
                    }
            }?:run {
                _loadingLiveData.postValue(false)
                _addressLiveData.postValue(null)
            }

        } catch (e: Exception) {
            _loadingLiveData.postValue(false)
            _addressLiveData.postValue(null)
        }
    }

    private fun findAddress(context: Context,location: Location) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val geocoder = Geocoder(context, Locale.getDefault())
                    geocoder.getFromLocation(location.latitude, location.longitude, 1, object : Geocoder.GeocodeListener {
                        override fun onGeocode(addresses: MutableList<Address>) {
                            val address = addresses.firstOrNull()?.getAddressLine(0)
                                ?: "Unknown Place"
                            _addressLiveData.postValue(address)
                            _loadingLiveData.postValue(false)
                        }

                        override fun onError(errorMessage: String?) {
                            _loadingLiveData.postValue(false)
                            _addressLiveData.postValue(null)
                        }
                    })
                } catch (e: Exception) {
                    _loadingLiveData.postValue(false)
                    _addressLiveData.postValue(null)
                }
            }

        } else {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val geocoder = Geocoder(context, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                    val address = addresses?.firstOrNull()?.getAddressLine(0)
                        ?: "Unknown Place"

                    _addressLiveData.postValue(address)
                    _loadingLiveData.postValue(false)
                } catch (e: Exception) {
                    _loadingLiveData.postValue(false)
                    _addressLiveData.postValue(null)
                }
            }
        }
    }

    private fun findAddressForCAA(context: Context,location: Location) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val geocoder = Geocoder(context, Locale.getDefault())
                    geocoder.getFromLocation(location.latitude, location.longitude, 1, object : Geocoder.GeocodeListener {
                        override fun onGeocode(addresses: MutableList<Address>) {
                            val address = addresses.firstOrNull()?.getAddressLine(0)
                                ?: "Unknown Place"
                            _locationLiveData.postValue(Pair(location,address))
                            _loadingLiveData.postValue(false)
                        }

                        override fun onError(errorMessage: String?) {
                            _loadingLiveData.postValue(false)
                            _locationLiveData.postValue(null)
                        }
                    })
                } catch (e: Exception) {
                    _loadingLiveData.postValue(false)
                    _locationLiveData.postValue(null)
                }
            }

        } else {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val geocoder = Geocoder(context, Locale.getDefault())
                    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                    val address = addresses?.firstOrNull()?.getAddressLine(0)
                        ?: "Unknown Place"

                    _locationLiveData.postValue(Pair(location,address))
                    _loadingLiveData.postValue(false)
                } catch (e: Exception) {
                    _loadingLiveData.postValue(false)
                    _locationLiveData.postValue(null)
                }
            }
        }
    }

}
