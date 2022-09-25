package com.orbitalsonic.generalproject.helpers.adapters.binding

import android.net.Uri
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import java.io.File

@BindingAdapter("imageUri")
fun ShapeableImageView.setImageFromUri(imageUri: Uri?) {
    Glide
        .with(this)
        .load(imageUri)
        .into(this)
}

@BindingAdapter("imageUri")
fun ImageFilterView.setImageFromUri(imageUri: Uri?) {
    Glide
        .with(this)
        .load(imageUri)
        .into(this)
}

@BindingAdapter("imagePath")
fun ShapeableImageView.setImageFromPath(imagePath: File) {
    Glide
        .with(this)
        .load(imagePath.toString())
        .into(this)
}

@BindingAdapter("imagePath")
fun ImageFilterView.setImageFromPath(imagePath: File) {
    Glide
        .with(this)
        .load(imagePath.toString())
        .into(this)
}

@BindingAdapter("imageId")
fun ShapeableImageView.setImageFromDrawable(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}

@BindingAdapter("imageId")
fun ImageFilterView.setImageFromDrawable(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}

@BindingAdapter("imageAsset")
fun ShapeableImageView.setImageFromAssets(imageAsset: String) {
    Glide
        .with(this)
        .load(Uri.parse("file:///android_asset/flags/$imageAsset.webp"))
        .into(this)
}

@BindingAdapter("imageAsset")
fun ImageFilterView.setImageFromAssets(imageAsset: String) {
    Glide
        .with(this)
        .load(Uri.parse("file:///android_asset/flags/$imageAsset.webp"))
        .into(this)
}
