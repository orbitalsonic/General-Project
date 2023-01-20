package com.orbitalsonic.generalproject.helpers.utils

import android.app.Activity
import android.app.SearchManager
import android.content.*
import android.net.Uri
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException

object SettingUtils {

    fun Activity?.openPlayStoreApp(packageName: String) {
        this?.let {
            try {
                it.startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            } catch (ex: Exception) {
                ex.recordException("openPlayStoreApp")
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
                ex.recordException("rateUs")
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
                ex.recordException("aboutUs")
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
                ex.recordException("privacyPolicy")
            }
        }
    }

    fun Activity?.feedback() {
        this?.let {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "message/rfc822"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(it.getString(R.string.app_email)))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.app_name))
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Feedback...")
            try {
                it.startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                ex.recordException("feedback")
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
                ex.recordException("shareApp")
            }
        }
    }

    fun Activity?.copyClipboardData(text: String) {
        this?.let {
            try {
                val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText("simple text", text)
                clipboard.setPrimaryClip(clip)
            } catch (ex: Exception) {
                ex.recordException("copyClipboardData")
            }
        }
    }

    fun Activity?.shareTextData(mData: String) {
        this?.let {
            try {
                val intentTextData = Intent(Intent.ACTION_SEND)
                intentTextData.type = "text/plain"
                intentTextData.putExtra(Intent.EXTRA_SUBJECT, "Data")
                intentTextData.putExtra(Intent.EXTRA_TEXT, mData)
                it.startActivity(Intent.createChooser(intentTextData, "Choose to share"))
            } catch (ex: Exception) {
                ex.recordException("shareTextData")
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
                ex.recordException("searchData")
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
                ex.recordException("translateDate")
            }
        }
    }
}