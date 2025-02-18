package com.orbitalsonic.generalproject.presentation.samples.permissions

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.orbitalsonic.generalproject.databinding.FragmentPermissionSampleBinding
import com.orbitalsonic.generalproject.helpers.permissions.isAudioPermissionGranted
import com.orbitalsonic.generalproject.helpers.settings.openSettingPage
import com.orbitalsonic.generalproject.helpers.ui.showSnackBar
import com.orbitalsonic.generalproject.helpers.ui.showToast
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.dialogs.callbacks.OnDialogClickListener
import com.orbitalsonic.generalproject.presentation.dialogs.myCustomDialog
import com.orbitalsonic.generalproject.presentation.dialogs.showAlertDialog
import com.orbitalsonic.generalproject.presentation.dialogs.showPermissionDialog

class FragmentPermissionSample :
    BaseFragment<FragmentPermissionSampleBinding>(FragmentPermissionSampleBinding::inflate) {

    private val audioPermissionResultLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            activity?.showToast("Permission Granted")
            binding.mtvPermission.text = "Permission Granted"
        } else {
            activity.showAlertDialog(
                title = "Permission Denied",
                message = "Permission was denied, but it's needed for this feature. You can grant it in settings.",
                positiveText = "Settings",
                negativeText = "Cancel",
                onPositiveClick = { activity.openSettingPage() }
            )
        }
    }

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks() {
        binding.btnPermission.setOnClickListener {
         askForAudioPermission()
        }
    }

    private fun askForAudioPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.RECORD_AUDIO
            )
        ) {
            activity?.showAlertDialog(
                title = "Permission Needed",
                message = "Audio permission is necessary to use voice-to-text.",
                positiveText = "OK",
                onPositiveClick = {
                    audioPermissionResultLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }
            )
        } else {
            activity?.showPermissionDialog(
                onGranted = {
                    audioPermissionResultLauncher.launch(Manifest.permission.RECORD_AUDIO)
                },
                onDenied = {
                    activity?.showToast("Permission Denied")
                    binding.mtvPermission.text = "Permission Denied"
                }
            )

        }
    }
}