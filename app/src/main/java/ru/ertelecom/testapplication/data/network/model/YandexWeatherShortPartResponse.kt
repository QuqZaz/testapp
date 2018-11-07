package ru.ertelecom.testapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class YandexWeatherShortPartResponse(
        @SerializedName("temp")
        val temp: Float,
        @SerializedName("feels_like")
        val feelsLike: Float,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("condition")
        val condition: String,
        @SerializedName("wind_speed")
        val windSpeed: Float,
        @SerializedName("wind_dir")
        val windDir: String,
        @SerializedName("pressure_mm")
        val pressure: Float
)