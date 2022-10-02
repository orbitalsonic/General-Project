package com.orbitalsonic.generalproject.gallery.ui.fragments.gallery

import android.app.Application
import android.content.ContentUris
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orbitalsonic.generalproject.MainApplication
import com.orbitalsonic.generalproject.gallery.helper.models.Picture
import com.orbitalsonic.generalproject.gallery.helper.utils.ConversionUtils.getDate
import com.orbitalsonic.generalproject.gallery.helper.utils.ConversionUtils.getFileSize
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class GalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val _picturesLiveData = MutableLiveData<List<Picture>>()
    val picturesLiveData: LiveData<List<Picture>> get() = _picturesLiveData

    private val _picturesList = ArrayList<Picture>()
    private val picturesList: List<Picture> get() = _picturesList

    private val _selectedPicturesList = ArrayList<Picture>()
    val selectedPicturesList: List<Picture> get() = _selectedPicturesList

    private var exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("SonicTag", ": ${throwable.message}")
        throwable.recordException("GalleryViewModel: CoroutineExceptionHandler")
    }

    fun fetchFiles() {
        CoroutineScope(Dispatchers.Main + exceptionHandler).launch {
            val arrayList = ArrayList<Picture>()
            CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

                val projection = arrayOf(
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media.DATE_ADDED,
                    MediaStore.Images.Media.DATE_MODIFIED,
                    MediaStore.Images.Media.SIZE
                )

                val orderBy = MediaStore.Images.Media.DATE_MODIFIED + " DESC"
                val cursor: Cursor? = getApplication<MainApplication>().contentResolver.query(
                    MediaStore.Images.Media.getContentUri("external"),
                    projection,
                    null,
                    null,
                    orderBy
                )

                cursor?.let {
                    val idCol = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                    val dataCol = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                    val addedCol = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)
                    val modifiedCol = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_MODIFIED)
                    val sizeCol = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)

                    if (it.moveToFirst()) {
                        do {
                            val fileUri: Uri = ContentUris.withAppendedId(MediaStore.Images.Media.getContentUri("external"), it.getString(idCol).toLong())
                            val data = it.getString(dataCol)
                            val dateAdded = it.getLong(addedCol)
                            val dateModified = it.getLong(modifiedCol)
                            val size = it.getLong(sizeCol)
                            val file = File(data)
                            val picture = Picture(file, fileUri, file.name, getDate(dateAdded * 1000), getDate(dateModified * 1000), getFileSize(size), dateAdded, dateModified, size)
                            if (picture.file.exists()) {
                                arrayList.add(picture)
                            }
                        } while (it.moveToNext())
                    }
                    it.close()
                }
            }.join()

            _picturesList.clear()
            _picturesList.addAll(arrayList)
            _picturesLiveData.value = arrayList.toList()
        }
    }

    fun onPictureClick(picture: Picture) {
        val indexOf = picturesList.indexOfFirst { it.file == picture.file }

        val temp = picturesList.map { it.copy() }
        temp[indexOf].isSelected = !picturesList[indexOf].isSelected

        // Updating selected list
        val indexOfSelected = selectedPicturesList.indexOfFirst { it.file == picture.file }
        if (indexOfSelected >= 0) {
            _selectedPicturesList.removeAt(indexOfSelected)
        } else {
            _selectedPicturesList.add(temp[indexOf])
        }

        _picturesLiveData.value = temp
        _picturesList.clear()
        _picturesList.addAll(temp)
    }
}