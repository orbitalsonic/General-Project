package com.orbitalsonic.generalproject.helpers.dataProvider

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.extensions.Extensions.isValidPosition

class DpLanguages {

    fun getLanguagesList(languageCode: String = ""): List<LanguageItem> {
        val arrayList = ArrayList<LanguageItem>().apply {
            add(LanguageItem(languageCode = "en", languageName = "English", countryFlag = R.drawable.flag_en, false))
            add(LanguageItem(languageCode = "af", languageName = "Afrikaans", countryFlag = R.drawable.flag_af, false))
            add(LanguageItem(languageCode = "ar", languageName = "Arabic (عربي)", countryFlag = R.drawable.flag_ar, false))
            add(LanguageItem(languageCode = "zh", languageName = "Chinese (简体中文)", countryFlag = R.drawable.flag_zh, false))
            add(LanguageItem(languageCode = "cs", languageName = "Czech (čeština)", countryFlag = R.drawable.flag_cs, false))
            add(LanguageItem(languageCode = "da", languageName = "Danish (dansk)", countryFlag = R.drawable.flag_da, false))
            add(LanguageItem(languageCode = "nl", languageName = "Dutch (Nederlands)", countryFlag = R.drawable.flag_nl, false))
            add(LanguageItem(languageCode = "fi", languageName = "Finnish (Suomalainen)", countryFlag = R.drawable.flag_fi, false))
            add(LanguageItem(languageCode = "fr", languageName = "French (Français)", countryFlag = R.drawable.flag_fr, false))
            add(LanguageItem(languageCode = "de", languageName = "German (Deutsch)", countryFlag = R.drawable.flag_de, false))
            add(LanguageItem(languageCode = "hi", languageName = "Hindi (हिन्दी)", countryFlag = R.drawable.flag_hi, false))
            add(LanguageItem(languageCode = "it", languageName = "Italian", countryFlag = R.drawable.flag_it, false))
            add(LanguageItem(languageCode = "ja", languageName = "Japanese (日本)", countryFlag = R.drawable.flag_ja, false))
            add(LanguageItem(languageCode = "ko", languageName = "Korean (한국인)", countryFlag = R.drawable.flag_ko, false))
            add(LanguageItem(languageCode = "ms", languageName = "Malay", countryFlag = R.drawable.flag_ms, false))
            add(LanguageItem(languageCode = "fa", languageName = "Persian (فارسي)", countryFlag = R.drawable.flag_fa, false))
            add(LanguageItem(languageCode = "pl", languageName = "Polish (Polski)", countryFlag = R.drawable.flag_pl, false))
            add(LanguageItem(languageCode = "pt", languageName = "Portuguese", countryFlag = R.drawable.flag_pt, false))
            add(LanguageItem(languageCode = "ru", languageName = "Russian (Русский)", countryFlag = R.drawable.flag_ru, false))
            add(LanguageItem(languageCode = "es", languageName = "Spanish (Española)", countryFlag = R.drawable.flag_es, false))
            add(LanguageItem(languageCode = "sv", languageName = "Swedish (svenska)", countryFlag = R.drawable.flag_sv, false))
            add(LanguageItem(languageCode = "th", languageName = "Thai (ไทย)", countryFlag = R.drawable.flag_th, false))
            add(LanguageItem(languageCode = "tr", languageName = "Turkish (Türkçe)", countryFlag = R.drawable.flag_tr, false))
            add(LanguageItem(languageCode = "uk", languageName = "Ukrainian (український)", countryFlag = R.drawable.flag_uk, false))
            add(LanguageItem(languageCode = "ur", languageName = "Urdu (اردو)", countryFlag = R.drawable.flag_ur, false))
            add(LanguageItem(languageCode = "vi", languageName = "Vietnamese (Tiếng Việt)", countryFlag = R.drawable.flag_vi, false))
        }

        val indexOf = arrayList.indexOfFirst { it.languageCode == languageCode }

        if (indexOf.isValidPosition(arrayList))
            arrayList[indexOf].isSelected = true
        else
            arrayList[0].isSelected = true

        return arrayList.toList()
    }
}