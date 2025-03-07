package com.orbitalsonic.generalproject.storage.provider

import com.orbitalsonic.generalproject.helpers.utils.isValidPosition
import com.orbitalsonic.generalproject.presentation.samples.language.models.LanguageItem

class DpLanguages {
    fun getLanguagesList(languageCode: String = ""): List<LanguageItem> {
        val arrayList = ArrayList<LanguageItem>().apply {
            add(
                LanguageItem(
                    languageCode = "en",
                    languageShortName = "English",
                    languageFullName = "English",
                    selected = false
                )
            )

            add(LanguageItem(
                languageCode = "ar",
                languageShortName = "Arabic",
                languageFullName = "Arabic (عربي)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "bg",
                languageShortName = "Bulgarian",
                languageFullName = "Bulgarian (български)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "bn",
                languageShortName = "Bangla",
                languageFullName = "Bangla (বাংলা)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ca",
                languageShortName = "Catalan",
                languageFullName = "Catalan (català)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "zh-CN",
                languageShortName = "Chinese-Simplified",
                languageFullName = "Chinese-Simplified (简体中文)",
                selected = false
            ))
            add(LanguageItem(
                languageCode = "zh-TW",
                languageShortName = "Chinese-Traditional",
                languageFullName = "Chinese-Traditional (中國傳統的)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hr",
                languageShortName = "Croatian",
                languageFullName = "Croatian (Hrvatski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "cs",
                languageShortName = "Czech",
                languageFullName = "Czech (čeština)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "da",
                languageShortName = "Danish",
                languageFullName = "Danish (dansk)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "nl",
                languageShortName = "Dutch",
                languageFullName = "Dutch (Nederlands)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "et",
                languageShortName = "Estonian",
                languageFullName = "Estonian (eesti keel)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "fi",
                languageShortName = "Finnish",
                languageFullName = "Finnish (Suomalainen)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "fr",
                languageShortName = "French",
                languageFullName = "French (Français)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "de",
                languageShortName = "German",
                languageFullName = "German (Deutsch)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "el",
                languageShortName = "Greek",
                languageFullName = "Greek (Ελληνικά)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "gu",
                languageShortName = "Gujarati",
                languageFullName = "Gujarati (ગુજરાતી)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hi",
                languageShortName = "Hindi",
                languageFullName = "Hindi (हिन्दी)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hu",
                languageShortName = "Hungarian",
                languageFullName = "Hungarian (Magyar)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "in",
                languageShortName = "Indonesian",
                languageFullName = "Indonesian",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "it",
                languageShortName = "Italian",
                languageFullName = "Italian",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ja",
                languageShortName = "Japanese",
                languageFullName = "Japanese (日本)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "kn",
                languageShortName = "Kannada",
                languageFullName = "Kannada (ಕನ್ನಡ)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ko",
                languageShortName = "Korean",
                languageFullName = "Korean (한국인)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "lv",
                languageShortName = "Latvian",
                languageFullName = "Latvian (latviski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "lt",
                languageShortName = "Lithuanian",
                languageFullName = "Lithuanian (lietuvių)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ms",
                languageShortName = "Malay",
                languageFullName = "Malay",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ml",
                languageShortName = "Malayalam",
                languageFullName = "Malayalam (മലയാളം)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "mr",
                languageShortName = "Marathi",
                languageFullName = "Marathi (मराठी)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "no",
                languageShortName = "Norwegian",
                languageFullName = "Norwegian (norsk)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pl",
                languageShortName = "Polish",
                languageFullName = "Polish (Polski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pt",
                languageShortName = "Portuguese",
                languageFullName = "Portuguese",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pa",
                languageShortName = "Punjabi",
                languageFullName = "Punjabi (ਪੰਜਾਬੀ)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ro",
                languageShortName = "Romanian",
                languageFullName = "Romanian (Română)",
                selected = false
            ))
            add(LanguageItem(
                languageCode = "ru",
                languageShortName = "Russian",
                languageFullName = "Russian (Русский)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sr",
                languageShortName = "Serbian",
                languageFullName = "Serbian (Српски)",
                selected = false,
            ))

            add(LanguageItem(
                languageCode = "sk",
                languageShortName = "Slovak",
                languageFullName = "Slovak (slovenský)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sl",
                languageShortName = "Slovenian",
                languageFullName = "Slovenian (Slovenščina)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "es",
                languageShortName = "Spanish",
                languageFullName = "Spanish (Española)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sv",
                languageShortName = "Swedish",
                languageFullName = "Swedish (svenska)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ta",
                languageShortName = "Tamil",
                languageFullName = "Tamil (தமிழ்)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "te",
                languageShortName = "Telugu",
                languageFullName = "Telugu (తెలుగు)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "th",
                languageShortName = "Thai",
                languageFullName = "Thai (ไทย)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "tr",
                languageShortName = "Turkish",
                languageFullName = "Turkish (Türkçe)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "uk",
                languageShortName = "Ukrainian",
                languageFullName = "Ukrainian (український)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ur",
                languageShortName = "Urdu",
                languageFullName = "Urdu (اردو)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "vi",
                languageShortName = "Vietnamese",
                languageFullName = "Vietnamese (Tiếng Việt)",
                selected = false
            ))

        }

        val indexOf = arrayList.indexOfFirst { it.languageCode == languageCode }

        if (indexOf.isValidPosition(arrayList))
            arrayList[indexOf].selected = true
        else
            arrayList[0].selected = true

        return arrayList.toList()
    }

    fun getLanguageItem(languageCode: String = ""):LanguageItem{
        val arrayList = ArrayList<LanguageItem>().apply {
            add(
                LanguageItem(
                    languageCode = "en",
                    languageShortName = "English",
                    languageFullName = "English",
                    selected = false
                )
            )

            add(LanguageItem(
                languageCode = "ar",
                languageShortName = "Arabic",
                languageFullName = "Arabic (عربي)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "bg",
                languageShortName = "Bulgarian",
                languageFullName = "Bulgarian (български)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "bn",
                languageShortName = "Bangla",
                languageFullName = "Bangla (বাংলা)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ca",
                languageShortName = "Catalan",
                languageFullName = "Catalan (català)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "zh-CN",
                languageShortName = "Chinese-Simplified",
                languageFullName = "Chinese-Simplified (简体中文)",
                selected = false
            ))
            add(LanguageItem(
                languageCode = "zh-TW",
                languageShortName = "Chinese-Traditional",
                languageFullName = "Chinese-Traditional (中國傳統的)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hr",
                languageShortName = "Croatian",
                languageFullName = "Croatian (Hrvatski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "cs",
                languageShortName = "Czech",
                languageFullName = "Czech (čeština)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "da",
                languageShortName = "Danish",
                languageFullName = "Danish (dansk)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "nl",
                languageShortName = "Dutch",
                languageFullName = "Dutch (Nederlands)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "et",
                languageShortName = "Estonian",
                languageFullName = "Estonian (eesti keel)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "fi",
                languageShortName = "Finnish",
                languageFullName = "Finnish (Suomalainen)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "fr",
                languageShortName = "French",
                languageFullName = "French (Français)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "de",
                languageShortName = "German",
                languageFullName = "German (Deutsch)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "el",
                languageShortName = "Greek",
                languageFullName = "Greek (Ελληνικά)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "gu",
                languageShortName = "Gujarati",
                languageFullName = "Gujarati (ગુજરાતી)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hi",
                languageShortName = "Hindi",
                languageFullName = "Hindi (हिन्दी)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "hu",
                languageShortName = "Hungarian",
                languageFullName = "Hungarian (Magyar)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "in",
                languageShortName = "Indonesian",
                languageFullName = "Indonesian",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "it",
                languageShortName = "Italian",
                languageFullName = "Italian",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ja",
                languageShortName = "Japanese",
                languageFullName = "Japanese (日本)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "kn",
                languageShortName = "Kannada",
                languageFullName = "Kannada (ಕನ್ನಡ)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ko",
                languageShortName = "Korean",
                languageFullName = "Korean (한국인)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "lv",
                languageShortName = "Latvian",
                languageFullName = "Latvian (latviski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "lt",
                languageShortName = "Lithuanian",
                languageFullName = "Lithuanian (lietuvių)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ms",
                languageShortName = "Malay",
                languageFullName = "Malay",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ml",
                languageShortName = "Malayalam",
                languageFullName = "Malayalam (മലയാളം)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "mr",
                languageShortName = "Marathi",
                languageFullName = "Marathi (मराठी)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "no",
                languageShortName = "Norwegian",
                languageFullName = "Norwegian (norsk)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pl",
                languageShortName = "Polish",
                languageFullName = "Polish (Polski)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pt",
                languageShortName = "Portuguese",
                languageFullName = "Portuguese",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "pa",
                languageShortName = "Punjabi",
                languageFullName = "Punjabi (ਪੰਜਾਬੀ)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ro",
                languageShortName = "Romanian",
                languageFullName = "Romanian (Română)",
                selected = false
            ))
            add(LanguageItem(
                languageCode = "ru",
                languageShortName = "Russian",
                languageFullName = "Russian (Русский)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sr",
                languageShortName = "Serbian",
                languageFullName = "Serbian (Српски)",
                selected = false,
            ))

            add(LanguageItem(
                languageCode = "sk",
                languageShortName = "Slovak",
                languageFullName = "Slovak (slovenský)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sl",
                languageShortName = "Slovenian",
                languageFullName = "Slovenian (Slovenščina)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "es",
                languageShortName = "Spanish",
                languageFullName = "Spanish (Española)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "sv",
                languageShortName = "Swedish",
                languageFullName = "Swedish (svenska)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ta",
                languageShortName = "Tamil",
                languageFullName = "Tamil (தமிழ்)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "te",
                languageShortName = "Telugu",
                languageFullName = "Telugu (తెలుగు)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "th",
                languageShortName = "Thai",
                languageFullName = "Thai (ไทย)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "tr",
                languageShortName = "Turkish",
                languageFullName = "Turkish (Türkçe)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "uk",
                languageShortName = "Ukrainian",
                languageFullName = "Ukrainian (український)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "ur",
                languageShortName = "Urdu",
                languageFullName = "Urdu (اردو)",
                selected = false
            ))

            add(LanguageItem(
                languageCode = "vi",
                languageShortName = "Vietnamese",
                languageFullName = "Vietnamese (Tiếng Việt)",
                selected = false
            ))

        }

        val indexOf = arrayList.indexOfFirst { it.languageCode == languageCode }

        return if (indexOf.isValidPosition(arrayList)){
            arrayList[indexOf].selected = true
            arrayList[indexOf]
        } else {
            arrayList[0].selected = true
            arrayList[0]
        }
    }
}