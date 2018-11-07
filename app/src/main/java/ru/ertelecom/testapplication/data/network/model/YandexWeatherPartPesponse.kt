package ru.ertelecom.testapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class YandexWeatherPartPesponse(
        @SerializedName("day_short")
        val dayShort: YandexWeatherShortPartResponse,
        @SerializedName("night_short")
        val nightShort: YandexWeatherShortPartResponse
)