package com.orbitalsonic.generalproject.ui.activities.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException
import com.orbitalsonic.generalproject.helpers.koin.DIComponent
import com.orbitalsonic.generalproject.helpers.utils.LocaleHelper

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity() {

    private val generalTAG = "GeneralTAG"

    protected val binding by lazy {
        DataBindingUtil.inflate<T>(
            layoutInflater,
            layoutId,
            null,
            false
        )
    }
    protected val diComponent by lazy { DIComponent() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    protected fun withDelay(delay: Long = 300, block: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(block, delay)
    }

    protected fun showKeyboard() {
        try {
            val imm: InputMethodManager? =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        } catch (ex: Exception) {
            ex.recordException("showKeyBoardTag")
        }
    }

    protected fun hideKeyboard() {
        try {
            val inputMethodManager: InputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            val view: IBinder? = findViewById<View?>(android.R.id.content)?.windowToken
            inputMethodManager.hideSoftInputFromWindow(view, 0)
        } catch (ex: Exception) {
            ex.recordException("hideKeyboard")
        }
    }

    /* ---------- Toast ---------- */

    protected fun showToast(message: String) {
        try {
            runOnUiThread {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        } catch (ex: Exception) {
            ex.recordException("showToast : ${javaClass.simpleName}")
        }
    }

    protected fun debugToast(message: String) {
        try {
            runOnUiThread {
                if (BuildConfig.DEBUG) {
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
        } catch (ex: Exception) {
            ex.recordException("debugToast : ${javaClass.simpleName}")
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(
            LocaleHelper.setLocale(
                newBase,
                diComponent.sharedPreferenceUtils.selectedLanguageCode
            )
        )
    }

    abstract fun onRecreate()
}