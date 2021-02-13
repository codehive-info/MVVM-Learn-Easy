package com.example.countries

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryname : String?,

    @SerializedName("flagPNG")
    val flag : String?,

    @SerializedName("capital")
    val capital : String?
    ) //data transfer object