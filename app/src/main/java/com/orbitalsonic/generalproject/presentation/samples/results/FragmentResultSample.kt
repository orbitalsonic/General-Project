package com.orbitalsonic.generalproject.presentation.samples.results

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import com.orbitalsonic.generalproject.databinding.FragmentResultSampleBinding
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.FOR_ANIMALS
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.FOR_BIRDS
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.WILDLIFE_DATA
import com.orbitalsonic.generalproject.helpers.constants.IntentConstants.WILDLIFE_SELECTION
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.samples.results.models.WildModel

class FragmentResultSample :
    BaseFragment<FragmentResultSampleBinding>(FragmentResultSampleBinding::inflate) {

    private val requestWildLifeActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.apply {
                    val wildModel =
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            getParcelableExtra(
                                WILDLIFE_DATA,
                                WildModel::class.java
                            )
                        } else {
                            getParcelableExtra(WILDLIFE_DATA) as? WildModel
                        }

                    setResult(wildModel)
                }
            }
        }

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks() {
        binding.apply {
            btnBirds.setOnClickListener {
                try {
                    val mIntent = Intent(activity, ResultSampleActivity::class.java)
                    mIntent.putExtra(WILDLIFE_SELECTION, FOR_BIRDS)
                    requestWildLifeActivity.launch(mIntent)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
            btnAnimal.setOnClickListener {
                try {
                    val mIntent = Intent(activity, ResultSampleActivity::class.java)
                    mIntent.putExtra(WILDLIFE_SELECTION, FOR_ANIMALS)
                    requestWildLifeActivity.launch(mIntent)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setResult(wildModel: WildModel?){
        wildModel?.let {
            binding.mtvResult.text = "${it.wildName}: ${it.wildInfo}"
        }
    }

}