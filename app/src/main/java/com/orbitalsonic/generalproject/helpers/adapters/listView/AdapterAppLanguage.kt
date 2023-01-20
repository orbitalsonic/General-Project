package com.orbitalsonic.generalproject.helpers.adapters.listView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ItemLanguageBinding
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem

class AdapterLanguage(context: Context, languages: List<LanguageItem>) : ArrayAdapter<LanguageItem>(context, 0, languages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, parent)
    }

    private fun createItemView(position: Int, parent: ViewGroup): View {
        val item = getItem(position)
        val binding = DataBindingUtil.inflate<ItemLanguageBinding>(LayoutInflater.from(context), R.layout.item_language, parent, false)
        binding.item = item
        return binding.root
    }
}