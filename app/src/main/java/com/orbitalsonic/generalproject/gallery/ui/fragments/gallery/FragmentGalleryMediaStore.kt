package com.orbitalsonic.generalproject.gallery.ui.fragments.gallery

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentGalleryMediaStoreBinding
import com.orbitalsonic.generalproject.gallery.helper.adapters.interfaces.OnPictureItemClickListener
import com.orbitalsonic.generalproject.gallery.helper.adapters.recyclerView.AdapterGallery
import com.orbitalsonic.generalproject.gallery.helper.models.Picture
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentGalleryMediaStore :
    BaseFragment<FragmentGalleryMediaStoreBinding>(R.layout.fragment_gallery_media_store) {

    private val viewModel: GalleryViewModel by viewModels()
    private lateinit var adapterGallery: AdapterGallery

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        initObservers()

        binding.fabDoneGallery.setOnClickListener { onDoneClick() }
    }

    override fun onViewCreatedEverytime() {

    }

    private fun initRecyclerView() {
        adapterGallery = AdapterGallery(object : OnPictureItemClickListener {
            override fun onPictureClick(picture: Picture) {
                viewModel.onPictureClick(picture)
            }
        })
        binding.recyclerViewImagesGallery.adapter = adapterGallery
    }

    private fun initObservers() = with(viewModel) {
        fetchFiles()
        picturesLiveData.observe(viewLifecycleOwner) {
            binding.progressBarGallery.visibility = View.GONE
            adapterGallery.submitList(it)
        }
    }

    private fun onDoneClick() {
        // Use the Kotlin extension in the fragment-ktx artifact
        val picturesArray = viewModel.selectedPicturesList.toTypedArray()
        setFragmentResult("requestKey", bundleOf("bundleKey" to picturesArray))
        onBackPressed()
    }

    override fun navIconBackPressed() {
        popFrom(R.id.fragmentGallery)
    }

    override fun onBackPressed() {
        popFrom(R.id.fragmentGallery)
    }
}