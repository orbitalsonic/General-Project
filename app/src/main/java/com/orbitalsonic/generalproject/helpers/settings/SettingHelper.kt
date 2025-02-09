package com.orbitalsonic.generalproject.helpers.settings

import android.app.Activity
import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.BuildConfig


fun Activity?.openPlayStoreApp(packageName: String) {
    this?.let {
        try {
            it.startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                )
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.openSettingPage() {
    this?.apply {
        try {
            Intent().apply {
                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                data = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
            }.also {
                if (it.resolveActivity(packageManager) != null) {
                    startActivity(it)
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.rateUs() {
    this?.let {
        try {
            it.startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + it.packageName)
                )
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.aboutUs() {
    this?.let {
        try {
            it.startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse(it.getString(R.string.about_link))
                )
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.privacyPolicy() {
    this?.let {
        try {
            it.startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse(it.getString(R.string.privacy_link))
                )
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.termsAndConditions() {
    this?.let {
        try {
            it.startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse(it.getString(R.string.terms_condition_link))
                )
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.support() {
    this?.let {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:${it.getString(R.string.support_email)}")
            putExtra(Intent.EXTRA_SUBJECT, "Support: ${it.getString(R.string.app_name)}")
        }
        try {
            it.startActivity(emailIntent)
        } catch (ex: ActivityNotFoundException) {
            ex.printStackTrace()
        }
    }
}



fun Activity?.bugReport(text:String) {
    this?.let {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:${it.getString(R.string.help_email)}")
            putExtra(Intent.EXTRA_SUBJECT, "Bug Report: ${it.getString(R.string.app_name)}")
            putExtra(Intent.EXTRA_TEXT, text)
        }
        try {
            it.startActivity(emailIntent)
        } catch (ex: ActivityNotFoundException) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.shareApp() {
    this?.let {
        try {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.app_name))
            sendIntent.putExtra(
                Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=${it.packageName}"
            )
            sendIntent.type = "text/plain"
            it.startActivity(sendIntent)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Context?.copyClipboardData(text: String) {
    this?.let {
        try {
            val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", text)
            clipboard.setPrimaryClip(clip)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.shareTextData(text: String) {
    this?.let {
        try {
            val intentTextData = Intent(Intent.ACTION_SEND)
            intentTextData.type = "text/plain"
            intentTextData.putExtra(Intent.EXTRA_SUBJECT, "Data")
            intentTextData.putExtra(Intent.EXTRA_TEXT, text)
            it.startActivity(Intent.createChooser(intentTextData, "Choose to share"))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.searchData(text: String) {
    this?.let {
        try {
            val intentSearch = Intent(Intent.ACTION_WEB_SEARCH)
            intentSearch.putExtra(SearchManager.QUERY, text)
            it.startActivity(intentSearch)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.translateDate(mData: String) {
    this?.let {
        try {
            val url = "https://translate.google.com/#view=home&op=translate&sl=auto&tl=en&text=$mData"
            val intentTranslate = Intent(Intent.ACTION_VIEW)
            intentTranslate.data = Uri.parse(url)
            it.startActivity(intentTranslate)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.openSubscriptions() {
    this?.let {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/account/subscriptions?package=${it.packageName}")))
        } catch (ex: ActivityNotFoundException) {
            ex.printStackTrace()
        }
    }
}

fun Activity?.openAccessibilitySettings() {
    this?.let {
        try {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        } catch (ex: ActivityNotFoundException) {
            ex.printStackTrace()
        }
    }
}