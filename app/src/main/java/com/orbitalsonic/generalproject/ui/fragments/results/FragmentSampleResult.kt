package com.orbitalsonic.generalproject.ui.fragments.results

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSampleResultBinding
import com.orbitalsonic.generalproject.ui.activities.SampleResult
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentSampleResult : BaseFragment<FragmentSampleResultBinding>(R.layout.fragment_sample_result) {

    override fun onViewCreatedOneTime() {
        binding.mbCounterSampleResult.setOnClickListener { askForCounter() }
    }

    override fun onViewCreatedEverytime() {

    }

    private fun askForCounter() {
        val intent = Intent(globalActivity, SampleResult::class.java)
        requestActivityResult.launch(intent)
    }

    override fun onBackPressed() {
        popFrom(R.id.fragmentSampleResult)
    }

    /* ----------- Apis ----------- */

    private val requestActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val result = it.data
            binding.mtvResultSampleResult.text = result?.getStringExtra("text").toString()
        }
    }
}