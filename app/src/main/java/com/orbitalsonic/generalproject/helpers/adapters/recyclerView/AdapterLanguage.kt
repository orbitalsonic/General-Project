package com.orbitalsonic.generalproject.helpers.adapters.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ItemLanguageBinding
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.interfaces.OnLanguageItemClickListener

class AdapterLanguage(private val onLanguageItemClickListener: OnLanguageItemClickListener) : ListAdapter<LanguageItem, AdapterLanguage.CustomViewHolder>(diffUtilLanguageItem) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemLanguageBinding>(layoutInflater, R.layout.item_language, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            item = currentItem
            itemClick = onLanguageItemClickListener

            /**
             *         Selector did not work in xml if you are using only drawable not selector use it in xml file
             *         android:background="@{item.isSelected ? @drawable/bg_lang_selected : @drawable/bg_lang_unselected}"
             */

            langItemLayout.background = if (currentItem.isSelected) {
                ContextCompat.getDrawable(root.context, R.drawable.bg_lang_selected)
            } else {
                ContextCompat.getDrawable(root.context, R.drawable.bg_lang_unselected)
            }
        }
    }

    inner class CustomViewHolder(val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffUtilLanguageItem = object : DiffUtil.ItemCallback<LanguageItem>() {
            override fun areItemsTheSame(oldItem: LanguageItem, newItem: LanguageItem): Boolean {
                return oldItem.languageCode == newItem.languageCode
            }

            override fun areContentsTheSame(oldItem: LanguageItem, newItem: LanguageItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}