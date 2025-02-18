package com.orbitalsonic.generalproject.presentation.samples.permissions

import com.orbitalsonic.generalproject.databinding.FragmentPermissionSampleBinding
import com.orbitalsonic.generalproject.helpers.ui.showToast
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.dialogs.callbacks.OnDialogClickListener
import com.orbitalsonic.generalproject.presentation.dialogs.myCustomDialog
import com.orbitalsonic.generalproject.presentation.dialogs.showPermissionDialog

class FragmentPermissionSample :
    BaseFragment<FragmentPermissionSampleBinding>(FragmentPermissionSampleBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks() {
        binding.apply {
            btnPermission.setOnClickListener {
                activity.showPermissionDialog(
                    onGranted = {
                        activity.showToast("Permission Granted")
                        mtvPermission.text = "Permission Granted"
                    },
                    onDenied = {
                        activity.showToast("Permission Granted")
                        mtvPermission.text = "Permission Denied"
                    }
                )
            }
        }
    }

}