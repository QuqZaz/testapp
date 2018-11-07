package ru.ertelecom.testapplication.domain.model

data class Weather(
        val temp: Float,
        val windSpeed: Float,
        val feelsLike: Float,
        val icon: String,
        val condition: String,
        val windDir: String,
        val pressure: Float,
        val obsTime: Long,
        val typeTime: TypeTime,
        val isCurrent: Boolean
)