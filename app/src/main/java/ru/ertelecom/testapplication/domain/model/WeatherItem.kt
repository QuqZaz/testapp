package ru.ertelecom.testapplication.domain.model

data class WeatherItem(
        val icon: String,
        val date: String,
        val temp: String,
        val day: Boolean
)