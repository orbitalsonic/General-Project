package com.orbitalsonic.generalproject.presentation.samples.language.repository

import android.util.Log
import com.orbitalsonic.generalproject.presentation.samples.language.models.LanguageItem
import com.orbitalsonic.generalproject.storage.provider.DpLanguages
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.Locale

object LanguageRepository {
    private var isSearching = false
    private val exceptionHandlerSearch = CoroutineExceptionHandler { _, exception ->
        Log.e("LanguageRepositoryTAG", "${exception.message}")
        isSearching = false
    }

    fun searchLanguage(query: String, langCode: String, callback: (langList:List<LanguageItem>) -> Unit) {
        if (!isSearching) {
            val languageList = ArrayList<LanguageItem>()
            val searchList = ArrayList<LanguageItem>()
            isSearching = true
            CoroutineScope(Dispatchers.Main + exceptionHandlerSearch).launch {
                async(Dispatchers.IO + exceptionHandlerSearch) {
                    languageList.addAll(DpLanguages().getLanguagesList(langCode))
                    for (item in languageList) {
                        if (item.languageFullName.lowercase(Locale.ROOT)
                                .contains(query.lowercase(Locale.getDefault()))
                        ) {
                            searchList.add(item)
                        }
                    }
                }.await()
                callback.invoke(searchList)
                isSearching = false
            }
        }
    }
}