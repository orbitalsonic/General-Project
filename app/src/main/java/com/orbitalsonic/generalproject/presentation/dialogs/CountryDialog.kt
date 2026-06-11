package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import com.orbitalsonic.generalproject.helpers.ui.safeDialog

fun Activity?.showCountryDialog(
    onItemSelected: (String) -> Unit
) {
    safeDialog { activity ->

        val nuclearCountries = arrayOf(
            "Russia",
            "United States",
            "China",
            "France",
            "United Kingdom",
            "Pakistan",
            "India",
            "Israel",
            "North Korea"
        )

        AlertDialog.Builder(activity)
            .setTitle("Select a Nuclear Country")
            .setSingleChoiceItems(nuclearCountries, 0) { dialog, which ->
                onItemSelected(nuclearCountries[which])
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}