package com.orbitalsonic.generalproject.ui.fragments.base

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException

open class FragmentGeneral : Fragment() {

    private val generalTAG = "GeneralTAG"

    fun withDelay(delay: Long = 300, block: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(block, delay)
    }

    fun getResString(stringId: Int): String {
        return context?.resources?.getString(stringId) ?: ""
    }

    fun showKeyboard() {
        try {
            val imm: InputMethodManager? = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }catch (ex:Exception){
            ex.recordException("showKeyBoardTag")
        }

    }

    fun hideKeyboard() {
        try {
            val inputMethodManager: InputMethodManager = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view: View? = activity?.currentFocus
            if (view == null) {
                view = View(activity)
            }
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }catch (ex:Exception){
            ex.recordException("hideKeyboard")
        }

    }

    /* ---------- Toast ---------- */

    fun showToast(message: String) {
        activity?.let {
            try {
                it.runOnUiThread {
                    Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
                }
            } catch (ex: Exception) {
                ex.recordException("showToast : ${it.javaClass.simpleName}")
            }
        }
    }

    fun debugToast(message: String) {
        activity?.let {
            try {
                it.runOnUiThread {
                    if (BuildConfig.DEBUG) {
                        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (ex: Exception) {
                ex.recordException("debugToast : ${it.javaClass.simpleName}")
            }
        }
    }

    fun showToast(stringId: Int) {
        val message = getResString(stringId)
        showToast(message)
    }

    /* ---------- Snackbar ---------- */

    fun showSnackBar(message: String) {
        this.view?.let { v ->
            activity?.let {
                try {
                    it.runOnUiThread {
                        Snackbar.make(v.rootView, message, Snackbar.LENGTH_SHORT).show()
                    }
                } catch (ex: Exception) {
                    ex.recordException("showSnackBar : ${it.javaClass.simpleName}")
                }
            }
        }
    }

}