package com.orbitalsonic.generalproject.presentation.samples.location

import android.Manifest
import android.content.Intent
import android.location.Location
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.orbitalsonic.generalproject.databinding.FragmentLocationSampleBinding
import com.orbitalsonic.generalproject.helpers.permissions.isGpsEnabled
import com.orbitalsonic.generalproject.helpers.permissions.isLocationPermissionGranted
import com.orbitalsonic.generalproject.helpers.settings.openSettingPage
import com.orbitalsonic.generalproject.helpers.ui.showToast
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.dialogs.showAlertDialog
import com.orbitalsonic.generalproject.presentation.dialogs.showPermissionDialog

class FragmentLocationSample :
    BaseFragment<FragmentLocationSampleBinding>(FragmentLocationSampleBinding::inflate) {

    private val viewModel: LocationViewModel by viewModels()

    private val locationPermissionResultLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val isFineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val isCoarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        if (isFineLocationGranted || isCoarseLocationGranted) {
            activity?.showToast("Permission Granted")
        } else {
            activity?.showAlertDialog(
                title = "Permission Denied",
                message = "Permission was denied, but it's needed for location. You can grant it in settings.",
                positiveText = "Settings",
                negativeText = "Cancel",
                onPositiveClick = { activity?.openSettingPage() }
            )
        }
    }


    override fun onViewCreated() {
        setupObservers()
        setupClicks()
    }

    private fun setupObservers() {
        viewModel.coordinatesLiveData.observe(viewLifecycleOwner) { location: Location? ->
            val coordinates =  location?.let {
                 "Latitude: ${it.latitude}, Longitude: ${it.longitude}"
            }?:run {
                "Coordinates: Null"
            }
            binding.mtvCoordinates.text = coordinates
        }

        viewModel.addressLiveData.observe(viewLifecycleOwner) { address: String? ->
            val mAddress = address ?: "Address: Null"
            binding.mtvAddress.text = "Address: $mAddress"
        }
        viewModel.locationLiveData.observe(viewLifecycleOwner) { locationPair: Pair<Location, String>? ->
            locationPair?.let {
                binding.mtvCoordinates.text =  "Latitude: ${it.first.latitude}, Longitude: ${it.first.longitude}"
                binding.mtvAddress.text = "Address: ${it.second}"
            }?:run {
                binding.mtvCoordinates.text = "Coordinates: Null"
                binding.mtvAddress.text = "Address: Null"
            }
        }

        viewModel.loadingLiveData.observe(viewLifecycleOwner) { isLoading ->
            binding.apply {
                if (isLoading){
                    binding.mtvCoordinates.text = "Coordinates: ----"
                    binding.mtvAddress.text = "Address: ----"
                }
                binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
                binding.btnCoordinates.isEnabled = !isLoading
                binding.btnAddress.isEnabled = !isLoading
                binding.btnCoordsAddress.isEnabled = !isLoading
            }
        }
    }

    private fun setupClicks() {
        binding.btnCoordinates.setOnClickListener {
            if (activity.isGpsEnabled()){
                if (activity.isLocationPermissionGranted()){
                    viewModel.fetchCoordinates(activity)
                }else{
                    askForLocationPermission()
                }
            }else{
                showGPSDialog()
            }
        }

        binding.btnAddress.setOnClickListener {
            if (activity.isGpsEnabled()){
                if (activity.isLocationPermissionGranted()){
                    viewModel.fetchAddress(activity)
                }else{
                    askForLocationPermission()
                }
            }else{
                showGPSDialog()
            }

        }

        binding.btnCoordsAddress.setOnClickListener {
            if (activity.isGpsEnabled()){
                if (activity.isLocationPermissionGranted()){
                    viewModel.fetchCoordsAndAddress(activity)
                }else{
                    askForLocationPermission()
                }
            }else{
                showGPSDialog()
            }

        }

    }

    private fun askForLocationPermission() {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        if (permissions.any { ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), it) }) {
            activity?.showAlertDialog(
                title = "Permission Needed",
                message = "Location permission is necessary to fetch coordinates and address.",
                positiveText = "OK",
                onPositiveClick = {
                    locationPermissionResultLauncher.launch(permissions)
                }
            )
        } else {
            activity?.showPermissionDialog(
                onGranted = {
                    locationPermissionResultLauncher.launch(permissions)
                },
                onDenied = {
                    activity?.showToast("Permission Denied")
                }
            )
        }
    }

    private fun showGPSDialog(){
        activity.showAlertDialog(
            title = "GPS Disabled",
            message = "Please enable GPS to get Location.",
            positiveText = "Settings",
            negativeText = "Cancel",
            onPositiveClick = {
                val settingsIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(settingsIntent)
            }
        )
    }

}