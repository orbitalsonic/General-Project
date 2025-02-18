package com.orbitalsonic.generalproject.presentation.samples.results

import android.app.Activity
import android.content.Intent
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityResultSampleBinding
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.FOR_ANIMALS
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.FOR_BIRDS
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.WILDLIFE_DATA
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.WILDLIFE_SELECTION
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity
import com.orbitalsonic.generalproject.presentation.samples.results.models.WildModel

class ResultSampleActivity :
    BaseActivity<ActivityResultSampleBinding>(ActivityResultSampleBinding::inflate) {

    private var wildSelection: String = FOR_BIRDS

    private val birdsInfo = "A powerful bird that flies high and fast, often living in mountains."
    private val animalInfo = "A strong big cat with sharp teeth and claws, known as the king of the jungle."

    override fun onCreated() {
        statusBarColorUpdate(R.color.primary600)
        initToolbar()
        fetchingValuesFromIntent()
        setValues()
        setupClicks()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun fetchingValuesFromIntent() {
        intent.extras?.apply {
            wildSelection = getString(WILDLIFE_SELECTION) ?: FOR_BIRDS
        }
    }

    private fun setValues(){
        binding.apply {
            mtvWildInfo.text = when(wildSelection){
                FOR_BIRDS -> "Eagle: $birdsInfo"
                FOR_ANIMALS -> "Lion: $animalInfo"
                else -> birdsInfo
            }

        }

    }
    private fun setupClicks() {
        binding.btnSetResult.setOnClickListener {
            val (name, info) = when (wildSelection) {
                FOR_ANIMALS -> "Lion" to animalInfo
                else -> "Eagle" to birdsInfo
            }
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(WILDLIFE_DATA, WildModel(wildName = name, wildInfo = info))
            })
            finish()
        }
    }

}