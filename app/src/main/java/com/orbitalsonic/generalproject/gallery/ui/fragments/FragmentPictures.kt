package com.orbitalsonic.generalproject.gallery.ui.fragments

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentPicturesBinding
import com.orbitalsonic.generalproject.gallery.helper.adapters.interfaces.OnPictureItemClickListener
import com.orbitalsonic.generalproject.gallery.helper.adapters.recyclerView.AdapterGallery
import com.orbitalsonic.generalproject.gallery.helper.models.Picture
import com.orbitalsonic.generalproject.gallery.ui.fragments.gallery.GalleryViewModel
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentPictures : BaseFragment<FragmentPicturesBinding>(R.layout.fragment_pictures) {

    private val viewModel: GalleryViewModel by viewModels()
    private lateinit var adapterGallery: AdapterGallery

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        checkResultApi()

        binding.fabGalleryPictures.setOnClickListener { askForPermission() }
    }

    override fun onViewCreatedEverytime() {

    }

    private fun initRecyclerView() {
        adapterGallery = AdapterGallery(object : OnPictureItemClickListener {
            override fun onPictureClick(picture: Picture) {}
        })
        binding.recyclerViewImagesPictures.adapter = adapterGallery
    }

    private fun checkResultApi() {
        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getParcelableArray("bundleKey")
            result?.let {
                val pictureList = it.toList() as List<Picture>
                adapterGallery.submitList(pictureList)
            }
        }
    }

    private fun askForPermission() {
        requestPermissionLauncher.launch(READ_EXTERNAL_STORAGE)
    }

    override fun onBackPressed() {
        popFrom(R.id.fragmentPictures)
    }

    /* _________________________ Apis _________________________ */

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            onPermissionGranted()
        } else {
            showToast(R.string.permission_required)
        }
    }

    private fun onPermissionGranted() {
        navigateTo(R.id.fragmentPictures, R.id.action_fragmentPictures_to_fragmentGallery)
    }
}