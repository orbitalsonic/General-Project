package com.orbitalsonic.generalproject.presentation.samples.language.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ItemLanguageBinding
import com.orbitalsonic.generalproject.presentation.samples.language.interfaces.OnLanguageItemClickListener
import com.orbitalsonic.generalproject.presentation.samples.language.models.LanguageItem

class AdapterLanguage(private val onLanguageItemClickListener: OnLanguageItemClickListener) :
    ListAdapter<LanguageItem, RecyclerView.ViewHolder>(diffUtilIsm) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLanguageBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as CustomViewHolder<*>).globalBinding
        val currentItem = getItem(position)
        if (binding is ItemLanguageBinding) {
            binding.apply {
                mtvLanguageName.text = currentItem.languageFullName

                if (currentItem.selected.not()){
                    langItem.background = ContextCompat.getDrawable(root.context, R.drawable.bg_lang_unselected)
                    ivLangChecked.setImageResource(R.drawable.ic_lang_radio_unchecked)
                }else{
                    langItem.background = ContextCompat.getDrawable(root.context, R.drawable.bg_lang_selected)
                    ivLangChecked.setImageResource(R.drawable.ic_lang_radio_checked)
                }

                langItem.setOnClickListener {
                    onLanguageItemClickListener.onItemClick(currentItem)
                }
            }
        }
    }

    inner class CustomViewHolder<T : ViewBinding>(val globalBinding: T) :
        RecyclerView.ViewHolder(globalBinding.root)

    companion object {
        val diffUtilIsm = object : DiffUtil.ItemCallback<LanguageItem>() {
            override fun areItemsTheSame(
                oldItem: LanguageItem,
                newItem: LanguageItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LanguageItem,
                newItem: LanguageItem
            ): Boolean {
                return oldItem.languageCode == newItem.languageCode
            }
        }
    }

}