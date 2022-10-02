package com.orbitalsonic.generalproject.gallery.helper.adapters.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ItemImageBinding
import com.orbitalsonic.generalproject.gallery.helper.adapters.interfaces.OnPictureItemClickListener
import com.orbitalsonic.generalproject.gallery.helper.models.Picture

class AdapterGallery(private val onPictureItemClickListener: OnPictureItemClickListener) : ListAdapter<Picture, AdapterGallery.CustomViewHolder>(diffUtilGallery) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemImageBinding>(layoutInflater, R.layout.item_image, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            item = currentItem
            itemClick = onPictureItemClickListener
        }
    }

    inner class CustomViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffUtilGallery = object : DiffUtil.ItemCallback<Picture>() {
            override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
                return oldItem.exactDateCreated == newItem.exactDateCreated
            }

            override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
                return oldItem == newItem
            }
        }
    }
}