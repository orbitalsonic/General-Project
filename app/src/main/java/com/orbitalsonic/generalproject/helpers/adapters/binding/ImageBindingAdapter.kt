package com.orbitalsonic.generalproject.helpers.adapters.binding

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException
import java.io.File

/**
 *  Types of ImageView
 *      -> ImageView
 *      -> ImageFilterView
 *      -> ShapeableImageView
 *
 *  Customize following methods according to your ImageView class.
 */

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/**
 * @param: imageId -> Set image resource_id for this (e.g. R.drawable.img_dummy)
 *  Syntax:
 *      xml     -> app:imageId="@{imageResource}"
 *      kotlin  -> binding.imageView.setImageFromResource(R.drawable.img_dummy)
 */

@BindingAdapter("imageId")
fun ImageView.setImageFromResource(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}

/**
 * @param: imageUri -> Set image uri for this
 *  Syntax:
 *      xml     -> app:imageUri="@{uri}"
 *      kotlin  -> binding.imageView.setImageFromUri(uri)
 */

@BindingAdapter("imageUri")
fun ImageView.setImageFromUri(imageUri: Uri?) {
    Glide
        .with(this)
        .load(imageUri)
        .into(this)
}

/**
 * @param: imageFilePath -> Set image file path for this (e.g. File)
 *  Syntax:
 *      xml     -> app:imageFilePath="@{file}"
 *      kotlin  -> binding.imageView.setImageFromFilePath(file)
 */

@BindingAdapter("imageFilePath")
fun ImageView.setImageFromFilePath(imageFilePath: File) {
    try {
        if (imageFilePath.exists()) {
            Glide
                .with(this)
                .load(imageFilePath.toString())
                .into(this)
        }
    } catch (ex: SecurityException) {
        Log.e("TAG_ERROR", "setImageFromFilePath: ", ex)
        ex.recordException("setImageFromFilePath")
    }
}

/**
 * @param: imageDrawable -> Set image drawable object for this (e.g. Drawable)
 *  Syntax:
 *      xml     -> app:imageDrawable="@{@drawable/img_dummy}"
 *      kotlin  -> binding.imageView.setImageFromDrawable(Drawable)
 */

@BindingAdapter("imageDrawable")
fun ImageView.setImageFromDrawable(imageDrawable: Drawable) {
    Glide
        .with(this)
        .load(imageDrawable)
        .into(this)
}

/**
 * @param: imageAsset -> Set image from assets directory for this (e.g. Assets > flags > imgDummy)
 *  Syntax:
 *      xml     -> app:imageAsset="@{imgDummy}"
 *      kotlin  -> binding.imageView.setImageFromAssets("imgDummy")
 */

@BindingAdapter("imageAsset")
fun ImageView.setImageFromAssets(imageAsset: String) {
    Glide
        .with(this)
        .load(Uri.parse("file:///android_asset/flags/$imageAsset.webp"))
        .into(this)
}

/**
 * @param: tintImg -> Set attribute tint color for this
 *  Syntax:
 *      xml     ->    app:tintImg="@{item.isSelected}"
 */
@BindingAdapter("tintImg")
fun ImageView.setImageTint(isSelected:Boolean) {
//    if (isSelected){
//        val typedArray = context.theme.obtainStyledAttributes(intArrayOf(R.attr.colorFromAttribute))
//        val textColor = typedArray.getColor(0, 0)
//        typedArray.recycle()
//        setColorFilter(textColor)
//    }else{
//        setColorFilter(ContextCompat.getColor(context, R.color.normalColor))
//    }
}
