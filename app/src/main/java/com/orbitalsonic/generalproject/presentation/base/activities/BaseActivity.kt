package com.orbitalsonic.generalproject.presentation.base.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.orbitalsonic.generalproject.presentation.base.activities.enums.InsetsMode

abstract class BaseActivity<T : ViewBinding>(
    private val bindingFactory: (LayoutInflater) -> T
) : AppCompatActivity() {

    protected val binding: T by lazy { bindingFactory(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        initSplashScreen()
        super.onCreate(savedInstanceState)

        setupInsets(getInsetsMode())
        onCreated()
    }

    private fun setupInsets(mode: InsetsMode) {
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
            val isKeyboardVisible = insets.isVisible(WindowInsetsCompat.Type.ime())

            val bottomInset = if (isKeyboardVisible) imeInsets.bottom else systemBars.bottom

            val top = when (mode) {
                InsetsMode.TOP, InsetsMode.TOP_BOTTOM -> systemBars.top
                else -> 0
            }

            val bottom = when (mode) {
                InsetsMode.BOTTOM, InsetsMode.TOP_BOTTOM -> bottomInset
                else -> 0
            }

            view.setPadding(
                systemBars.left,
                top,
                systemBars.right,
                bottom
            )

            WindowInsetsCompat.CONSUMED
        }
    }

    /**
     * Override this in child activities
     * override fun getInsetsMode() = InsetsMode.EDGE_TO_EDGE
     */
    open fun getInsetsMode(): InsetsMode = InsetsMode.TOP_BOTTOM


    abstract fun onCreated()

    open fun initSplashScreen() {}
}