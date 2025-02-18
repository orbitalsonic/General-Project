package com.orbitalsonic.generalproject.presentation.samples.dialogsample

import com.orbitalsonic.generalproject.databinding.FragmentDialogSampleBinding
import com.orbitalsonic.generalproject.helpers.ui.showToast
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.dialogs.callbacks.OnDialogClickListener
import com.orbitalsonic.generalproject.presentation.dialogs.myCustomDialog
import com.orbitalsonic.generalproject.presentation.dialogs.showCountryDialog

class FragmentDialogSample :
    BaseFragment<FragmentDialogSampleBinding>(FragmentDialogSampleBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }


    private fun setupClicks() {
        binding.apply {
            btnSingleChoice.setOnClickListener {
                activity.showCountryDialog {
                    activity.showToast(it)
                }
            }

            btnCustomDialog.setOnClickListener {
                activity.myCustomDialog(object :OnDialogClickListener{
                    override fun onProceed() {
                        activity.showToast("Permission Granted")
                    }

                    override fun onCancel() {
                        activity.showToast("Permission Denied")
                    }
                })
            }
        }
    }

}