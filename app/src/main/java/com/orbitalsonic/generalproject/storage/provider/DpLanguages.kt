package com.orbitalsonic.generalproject.storage.provider

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.presentation.samples.language.models.LanguageItem

class DpLanguages {
    fun getLanguagesList(languageCode: String = ""): List<LanguageItem> {

        val list = arrayListOf(

            LanguageItem("en", "English", "English", R.drawable.flag_united_states_america, false),
            LanguageItem("af", "Afrikaans", "Afrikaans", R.drawable.flag_south_africa, false),
            LanguageItem("sq", "Albanian", "Albanian (shqiptare)", R.drawable.flag_albania, false),
            LanguageItem("am", "Amharic", "Amharic (አማርኛ)", R.drawable.flag_ethiopia, false),
            LanguageItem("ar", "Arabic", "Arabic (عربي)", R.drawable.flag_saudi_arabia, false),
            LanguageItem("hy", "Armenian", "Armenian (հայերեն)", R.drawable.flag_armenia, false),
            LanguageItem(
                "az",
                "Azerbaijani",
                "Azerbaijani (Azərbaycan)",
                R.drawable.flag_azerbaijan,
                false
            ),
            LanguageItem("eu", "Basque", "Basque (euskara)", R.drawable.flag_france, false),
            LanguageItem(
                "be",
                "Belarusian",
                "Belarusian (беларуская)",
                R.drawable.flag_belarus,
                false
            ),
            LanguageItem("bn", "Bangla", "Bangla (বাংলা)", R.drawable.flag_bangladesh, false),
            LanguageItem(
                "bs",
                "Bosnian",
                "Bosnian (bosanski)",
                R.drawable.flag_bosnia_herzegovina,
                false
            ),
            LanguageItem(
                "bg",
                "Bulgarian",
                "Bulgarian (български)",
                R.drawable.flag_bulgaria,
                false
            ),
            LanguageItem("ca", "Catalan", "Catalan (català)", R.drawable.flag_spain, false),
            LanguageItem("ceb", "Cebuano", "Cebuano", R.drawable.flag_philippines, false),
            LanguageItem("ny", "Chichewa", "Chichewa", R.drawable.flag_malawi, false),
            LanguageItem(
                "zh-CN",
                "Chinese-Simplified",
                "Chinese-Simplified (简体中文)",
                R.drawable.flag_china,
                false
            ),
            LanguageItem(
                "zh-TW",
                "Chinese-Traditional",
                "Chinese-Traditional (中國傳統的)",
                R.drawable.flag_china,
                false
            ),
            LanguageItem("co", "Corsican", "Corsican (Corsu)", R.drawable.flag_italy, false),
            LanguageItem("hr", "Croatian", "Croatian (Hrvatski)", R.drawable.flag_croatia, false),
            LanguageItem("cs", "Czech", "Czech (čeština)", R.drawable.flag_czech_republic, false),
            LanguageItem("da", "Danish", "Danish (dansk)", R.drawable.flag_denmark, false),
            LanguageItem("nl", "Dutch", "Dutch (Nederlands)", R.drawable.flag_netherlands, false),
            LanguageItem("eo", "Esperanto", "Esperanto", R.drawable.flag_belgium, false),
            LanguageItem("et", "Estonian", "Estonian (eesti keel)", R.drawable.flag_estonia, false),
            LanguageItem("tl", "Filipino", "Filipino", R.drawable.flag_philippines, false),
            LanguageItem("fi", "Finnish", "Finnish (Suomalainen)", R.drawable.flag_finland, false),
            LanguageItem("fr", "French", "French (Français)", R.drawable.flag_france, false),
            LanguageItem("fy", "Frisian", "Frisian", R.drawable.flag_netherlands, false),
            LanguageItem("gl", "Galician", "Galician (galego)", R.drawable.flag_spain, false),
            LanguageItem("ka", "Georgian", "Georgian (ქართული)", R.drawable.flag_georgia, false),
            LanguageItem("de", "German", "German (Deutsch)", R.drawable.flag_germany, false),
            LanguageItem("el", "Greek", "Greek (Ελληνικά)", R.drawable.flag_greece, false),
            LanguageItem("gu", "Gujarati", "Gujarati (ગુજરાતી)", R.drawable.flag_india, false),
            LanguageItem(
                "ht",
                "Haitian Creole",
                "Haitian Creole (Kreyòl ayisyen)",
                R.drawable.flag_haiti,
                false
            ),
            LanguageItem("ha", "Hausa", "Hausa", R.drawable.flag_nigeria, false),
            LanguageItem(
                "haw",
                "Hawaiian",
                "Hawaiian (Ōlelo Hawai)",
                R.drawable.flag_united_states_america,
                false
            ),
            LanguageItem("he", "Hebrew", "Hebrew (עִברִית)", R.drawable.flag_israel, false),
            LanguageItem("hi", "Hindi", "Hindi (हिन्दी)", R.drawable.flag_india, false),
            LanguageItem("hmn", "Hmong", "Hmong (Hmoob)", R.drawable.flag_china, false),
            LanguageItem("hu", "Hungarian", "Hungarian (Magyar)", R.drawable.flag_hungary, false),
            LanguageItem(
                "is",
                "Icelandic",
                "Icelandic (íslenskur)",
                R.drawable.flag_iceland,
                false
            ),
            LanguageItem("ig", "Igbo", "Igbo", R.drawable.flag_nigeria, false),
            LanguageItem("id", "Indonesian", "Indonesian", R.drawable.flag_indonesia, false),
            LanguageItem("ga", "Irish", "Irish (Gaeilge)", R.drawable.flag_ireland, false),
            LanguageItem("it", "Italian", "Italian", R.drawable.flag_italy, false),
            LanguageItem("ja", "Japanese", "Japanese (日本)", R.drawable.flag_japan, false),
            LanguageItem(
                "jw",
                "Javanese",
                "Javanese (basa jawa)",
                R.drawable.flag_indonesia,
                false
            ),
            LanguageItem("kn", "Kannada", "Kannada (ಕನ್ನಡ)", R.drawable.flag_india, false),
            LanguageItem("kk", "Kazakh", "Kazakh (қазақ)", R.drawable.flag_kazakhstan, false),
            LanguageItem("km", "Khmer", "Khmer (ខ្មែរ)", R.drawable.flag_cambodia, false),
            LanguageItem("ko", "Korean", "Korean (한국인)", R.drawable.flag_south_korea, false),
            LanguageItem("ku", "Kurdish", "Kurdish", R.drawable.flag_iraq, false),
            LanguageItem("ky", "Kyrgyz", "Kyrgyz (Кыргызча)", R.drawable.flag_kyrgyzstan, false),
            LanguageItem("lo", "Lao", "Lao (ພາສາລາວ)", R.drawable.flag_lao_republic, false),
            LanguageItem("la", "Latin", "Latin", R.drawable.flag_spain, false),
            LanguageItem("lv", "Latvian", "Latvian (latviski)", R.drawable.flag_latvia, false),
            LanguageItem(
                "lt",
                "Lithuanian",
                "Lithuanian (lietuvių)",
                R.drawable.flag_lithuania,
                false
            ),
            LanguageItem(
                "lb",
                "Luxembourgish",
                "Luxembourgish (lëtzebuergesch)",
                R.drawable.flag_luxembourg,
                false
            ),
            LanguageItem(
                "mk",
                "Macedonian",
                "Macedonian (македонски)",
                R.drawable.flag_macedonia,
                false
            ),
            LanguageItem("mg", "Malagasy", "Malagasy", R.drawable.flag_madagascar, false),
            LanguageItem("ms", "Malay", "Malay", R.drawable.flag_malaysia, false),
            LanguageItem("ml", "Malayalam", "Malayalam (മലയാളം)", R.drawable.flag_india, false),
            LanguageItem("mt", "Maltese", "Maltese", R.drawable.flag_malta, false),
            LanguageItem("mi", "Maori", "Maori", R.drawable.flag_new_zealand, false),
            LanguageItem("mr", "Marathi", "Marathi (मराठी)", R.drawable.flag_india, false),
            LanguageItem("mn", "Mongolian", "Mongolian (Монгол)", R.drawable.flag_mongolia, false),
            LanguageItem("my", "Myanmar", "Myanmar", R.drawable.flag_myanmar, false),
            LanguageItem("ne", "Nepali", "Nepali (नेपाली)", R.drawable.flag_nepal, false),
            LanguageItem("no", "Norwegian", "Norwegian (norsk)", R.drawable.flag_norway, false),
            LanguageItem("ps", "Pashto", "Pashto (پښتو)", R.drawable.flag_pakistan, false),
            LanguageItem("fa", "Persian", "Persian (فارسي)", R.drawable.flag_iran, false),
            LanguageItem("pl", "Polish", "Polish (Polski)", R.drawable.flag_poland, false),
            LanguageItem("pt", "Portuguese", "Portuguese", R.drawable.flag_portugal, false),
            LanguageItem("pa", "Punjabi", "Punjabi (ਪੰਜਾਬੀ)", R.drawable.flag_india, false),
            LanguageItem("ro", "Romanian", "Romanian (Română)", R.drawable.flag_romania, false),
            LanguageItem(
                "ru",
                "Russian",
                "Russian (Русский)",
                R.drawable.flag_russian_federation,
                false
            ),
            LanguageItem("sm", "Samoan", "Samoan", R.drawable.flag_samoa, false),
            LanguageItem(
                "gd",
                "Scottish Gaelic",
                "Scottish Gaelic (Gàidhlig na h-Alba)",
                R.drawable.flag_samoa,
                false
            ),
            LanguageItem("sr", "Serbian", "Serbian (Српски)", R.drawable.flag_serbia, false),
            LanguageItem("st", "Sesotho", "Sesotho", R.drawable.flag_south_africa, false),
            LanguageItem("sn", "Shona", "Shona", R.drawable.flag_zimbabwe, false),
            LanguageItem("sd", "Sindhi", "Sindhi (سنڌي)", R.drawable.flag_pakistan, false),
            LanguageItem("si", "Sinhala", "Sinhala (සිංහල)", R.drawable.flag_sri_lanka, false),
            LanguageItem("sk", "Slovak", "Slovak (slovenský)", R.drawable.flag_slovakia, false),
            LanguageItem(
                "sl",
                "Slovenian",
                "Slovenian (Slovenščina)",
                R.drawable.flag_slovenia,
                false
            ),
            LanguageItem("so", "Somali", "Somali", R.drawable.flag_somalia, false),
            LanguageItem("es", "Spanish", "Spanish (Española)", R.drawable.flag_spain, false),
            LanguageItem(
                "su",
                "Sundanese",
                "Sundanese (basa Sunda)",
                R.drawable.flag_indonesia,
                false
            ),
            LanguageItem("sw", "Swahili", "Swahili (kiswahili)", R.drawable.flag_kenya, false),
            LanguageItem("sv", "Swedish", "Swedish (svenska)", R.drawable.flag_sweden, false),
            LanguageItem("tg", "Tajik", "Tajik (тоҷикӣ)", R.drawable.flag_tajikistan, false),
            LanguageItem("ta", "Tamil", "Tamil (தமிழ்)", R.drawable.flag_india, false),
            LanguageItem("te", "Telugu", "Telugu (తెలుగు)", R.drawable.flag_india, false),
            LanguageItem("th", "Thai", "Thai (ไทย)", R.drawable.flag_thailand, false),
            LanguageItem("tr", "Turkish", "Turkish (Türkçe)", R.drawable.flag_turkey, false),
            LanguageItem(
                "uk",
                "Ukrainian",
                "Ukrainian (український)",
                R.drawable.flag_ukraine,
                false
            ),
            LanguageItem("ur", "Urdu", "Urdu (اردو)", R.drawable.flag_pakistan, false),
            LanguageItem("uz", "Uzbek", "Uzbek", R.drawable.flag_uzbekistan, false),
            LanguageItem(
                "vi",
                "Vietnamese",
                "Vietnamese (Tiếng Việt)",
                R.drawable.flag_viet_nam,
                false
            ),
            LanguageItem(
                "cy",
                "Welsh",
                "Welsh (Cymraeg)",
                R.drawable.flag_wallis_and_futuna,
                false
            ),
            LanguageItem("xh", "Xhosa", "Xhosa (isiXhosa)", R.drawable.flag_south_africa, false),
            LanguageItem("yi", "Yiddish", "Yiddish (יידיש)", R.drawable.flag_israel, false),
            LanguageItem("yo", "Yoruba", "Yoruba", R.drawable.flag_nigeria, false),
            LanguageItem("zu", "Zulu", "Zulu", R.drawable.flag_south_africa, false)
        )

        return list.map {
            it.copy(selected = it.languageCode == languageCode)
        }
    }
}