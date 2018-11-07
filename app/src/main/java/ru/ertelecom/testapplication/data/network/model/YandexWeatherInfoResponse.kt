package ru.ertelecom.testapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class YandexWeatherInfoResponse(
        @SerializedName("geoid")
        val geoId: Int,
        @SerializedName("url")
        val url: String,
        @SerializedName("def_pressure_mm")
        val defPressure: Int
)