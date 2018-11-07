package ru.ertelecom.testapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class YandexWeatherResponse(
        @SerializedName("now")
        val now: Int,
        @SerializedName("now_dt")
        val nowDt: String,
        @SerializedName("info")
        val info: YandexWeatherInfoResponse,
        @SerializedName("fact")
        val fact: YandexWeatherFactResponse,
        @SerializedName("forecasts")
        val forecast: ArrayList<YandexWeatherForecastsResponse>
)