package com.orbitalsonic.generalproject.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orbitalsonic.generalproject.databinding.ActivitySampleResultBinding

class SampleResult : AppCompatActivity() {

    private val binding by lazy { ActivitySampleResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mbSubmitSampleResult.setOnClickListener { onSubmitClick() }
    }

    private fun onSubmitClick() {
        val text = binding.etTextSampleResult.text?.trim().toString()
        if (text.isEmpty()) {
            binding.ltTextSampleResult.error = "Field can't be Empty"
            binding.ltTextSampleResult.isErrorEnabled = true
            return
        }
        val intent = Intent()
        intent.putExtra("text", text)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}