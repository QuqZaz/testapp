package ru.ertelecom.testapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class YandexWeatherForecastsResponse(
        @SerializedName("date_ts")
        val date: Long,
        @SerializedName("parts")
        val parts: YandexWeatherPartPesponse
)