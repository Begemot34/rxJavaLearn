package pw.kozhanov.rxjava.data.model.api


import com.google.gson.annotations.SerializedName

    data class CountriesResponseItem(
        @SerializedName("alpha2Code")
        val alpha2Code: String = "",
        @SerializedName("alpha3Code")
        val alpha3Code: String = "",
        @SerializedName("altSpellings")
        val altSpellings: List<String> = listOf(),
        @SerializedName("area")
        val area: Double = 0.0,
        @SerializedName("borders")
        val borders: List<String> = listOf(),
        @SerializedName("callingCodes")
        val callingCodes: List<String> = listOf(),
        @SerializedName("capital")
        val capital: String = "",
        @SerializedName("cioc")
        val cioc: String = "",
        @SerializedName("currencies")
        val currencies: List<Currency> = listOf(),
        @SerializedName("demonym")
        val demonym: String = "",
        @SerializedName("flag")
        val flag: String = "",
        @SerializedName("gini")
        val gini: Double = 0.0,
        @SerializedName("languages")
        val languages: List<Language> = listOf(),
        @SerializedName("latlng")
        val latlng: List<Double> = listOf(),
        @SerializedName("name")
        val name: String = "",
        @SerializedName("nativeName")
        val nativeName: String = "",
        @SerializedName("numericCode")
        val numericCode: String = "",
        @SerializedName("population")
        val population: Int = 0,
        @SerializedName("region")
        val region: String = "",
        @SerializedName("regionalBlocs")
        val regionalBlocs: List<RegionalBloc> = listOf(),
        @SerializedName("subregion")
        val subregion: String = "",
        @SerializedName("timezones")
        val timezones: List<String> = listOf(),
        @SerializedName("topLevelDomain")
        val topLevelDomain: List<String> = listOf(),
        @SerializedName("translations")
        val translations: Translations = Translations()
    ) {
        data class Currency(
            @SerializedName("code")
            val code: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("symbol")
            val symbol: String = ""
        )
    
        data class Language(
            @SerializedName("iso639_1")
            val iso6391: String = "",
            @SerializedName("iso639_2")
            val iso6392: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("nativeName")
            val nativeName: String = ""
        )
    
        data class RegionalBloc(
            @SerializedName("acronym")
            val acronym: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("otherAcronyms")
            val otherAcronyms: List<Any> = listOf(),
            @SerializedName("otherNames")
            val otherNames: List<String> = listOf()
        )
    
        data class Translations(
            @SerializedName("br")
            val br: String = "",
            @SerializedName("de")
            val de: String = "",
            @SerializedName("es")
            val es: String = "",
            @SerializedName("fa")
            val fa: String = "",
            @SerializedName("fr")
            val fr: String = "",
            @SerializedName("hr")
            val hr: String = "",
            @SerializedName("it")
            val it: String = "",
            @SerializedName("ja")
            val ja: String = "",
            @SerializedName("nl")
            val nl: String = "",
            @SerializedName("pt")
            val pt: String = ""
        )
    }

