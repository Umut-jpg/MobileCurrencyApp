package com.example.mycurrencyapp.Model

import com.google.gson.annotations.SerializedName


data class CurrencyData(

@SerializedName("Alış") val CurrencySales: String,
@SerializedName("Satış") val CurrencyBuying: String,
@SerializedName("Tür") val CurrencyName: String,
@SerializedName("Değişim") val change: String
)

data class ApiResponse(
    @SerializedName("Update_Date") val updateDate: String,
    /* CURR */
    @SerializedName("USD") val usd: CurrencyData,
    @SerializedName("EUR") val eur: CurrencyData,
    @SerializedName("GBP") val gbp: CurrencyData,
    @SerializedName("CHF") val chf: CurrencyData,
    @SerializedName("CAD") val cad: CurrencyData,
    @SerializedName("RUB") val rub: CurrencyData,
    @SerializedName("AED") val aed: CurrencyData,
    @SerializedName("AUD") val aud: CurrencyData,
    @SerializedName("DKK") val dkk: CurrencyData,
    @SerializedName("SEK") val sek: CurrencyData,
    @SerializedName("NOK") val nok: CurrencyData,
    @SerializedName("JPY") val jpy: CurrencyData,
    @SerializedName("KWD") val kwd: CurrencyData,
    @SerializedName("BHD") val  bhd: CurrencyData,
    @SerializedName("ZAR") val zar: CurrencyData,
    @SerializedName("SAR") val sar: CurrencyData,
    @SerializedName("LYD") val lyd: CurrencyData,
    @SerializedName("IQD") val ıqd: CurrencyData,
    @SerializedName("ILS") val ıls: CurrencyData,
    @SerializedName("IRR") val ırr: CurrencyData,
    @SerializedName("MXN") val MXN: CurrencyData,

    /* GOLD */
    @SerializedName("gram-altin") val gram: CurrencyData,
    @SerializedName("ons") val ons: CurrencyData,
    @SerializedName("ceyrek-altin") val ceyrek: CurrencyData,
    @SerializedName("yarim-altin") val yarim: CurrencyData,
    @SerializedName("tam-altin") val tam: CurrencyData,
    @SerializedName("gram-has-altin") val hasaltin: CurrencyData,
    @SerializedName("ata-altin") val ata: CurrencyData,
    @SerializedName("resat-altin") val resat: CurrencyData,
    @SerializedName("cumhuriyet-altini") val cumhuriyet: CurrencyData,
    @SerializedName("hamit-altin") val hamit: CurrencyData,
    @SerializedName("ikibucuk-altin") val ikibucluk: CurrencyData,
    @SerializedName("besli-altin") val besli: CurrencyData,
    @SerializedName("14-ayar-altin") val ondortayar: CurrencyData,
    @SerializedName("22-ayar-bilezik") val bilezik: CurrencyData,
    @SerializedName("18-ayar-altin") val onsekizayar: CurrencyData,
    @SerializedName("gumus") val gumus: CurrencyData,

    ) {
    fun getCurrencies(): Map<String, CurrencyData> {
        return mapOf(
            "USD" to usd,
            "EUR" to eur,
            "GBP" to gbp,
            "CHF" to chf,
            "CAD" to cad,
            "RUB" to rub,
            "AED" to aed,
            "AUD" to aud,
            "DKK" to dkk,
            "SEK" to sek,
            "NOK" to nok,
            "JPY" to jpy,
            "KWD" to kwd,
            "BHD" to bhd,
            "ZAR" to zar,
            "SAR" to sar,
            "LYD" to lyd,
            "IQD" to ıqd,
            "ILS" to ıls,
            "IRR" to ırr,
            "MXN" to MXN,
        )
    }

    fun getGolds(): Map<String, CurrencyData> {
        return mapOf(
            "GRAM" to gram,
            "Ons-" to ons,
            "Ceyrek" to ceyrek,
            "Yarim" to yarim,
            "Tam" to tam,
            "GramHas" to hasaltin,
            "Ata" to ata,
            "Resat" to resat,
            "Cumhuriyet" to cumhuriyet,
            "Hamit" to hamit,
            "IkiBucluk " to ikibucluk,
            "Besli" to besli,
            "14 Ayar Altin" to ondortayar,
            "22 Ayar Bilezik" to bilezik,
            "18 Ayar Altin" to onsekizayar,
            "Gumus" to gumus,

            )
    }
}




