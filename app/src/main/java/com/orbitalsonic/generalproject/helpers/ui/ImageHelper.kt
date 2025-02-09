package com.orbitalsonic.generalproject.helpers.ui

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.orbitalsonic.generalproject.R
import java.io.File


fun ImageView.setImageFromResource(@DrawableRes drawableId: Int) {
    Glide
        .with(this)
        .load(drawableId)
        .into(this)
}


fun ImageView.setImageFromUri(imageUri: Uri?) {
    Glide
        .with(this)
        .load(imageUri)
        .into(this)
}


fun ImageView.setImageFromFilePath(imageFilePath: File) {
    try {
        if (imageFilePath.exists()) {
            Glide
                .with(this)
                .load(imageFilePath.toString())
                .into(this)
        }
    } catch (ex: SecurityException) {
        ex.printStackTrace()
    }
}


fun ImageView.setImageFromDrawable(imgDrawable: Drawable) {
    Glide
        .with(this)
        .load(imgDrawable)
        .into(this)
}


fun ImageView.setImageFromAssets(imageAsset: String) {
    Glide
        .with(this)
        .load(Uri.parse("file:///android_asset/flags/$imageAsset.webp"))
        .into(this)
}


fun ImageView.setImageTint(selected: Boolean) {
    if (selected){
        setColorFilter(ContextCompat.getColor(context, R.color.black))
    }else{
        setColorFilter(ContextCompat.getColor(context, R.color.white))
    }
}


fun ImageView.setImageByName(name: String) {
    try {
        val resourceId: Int =
            resources.getIdentifier(name, "drawable", this.rootView.context.packageName)
        Glide
            .with(this)
            .load(resourceId)
            .into(this)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}