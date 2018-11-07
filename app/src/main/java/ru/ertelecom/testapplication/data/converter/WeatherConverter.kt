package ru.ertelecom.testapplication.data.converter

import ru.ertelecom.testapplication.data.network.model.YandexWeatherResponse
import ru.ertelecom.testapplication.domain.model.TypeTime
import ru.ertelecom.testapplication.domain.model.Weather

const val DAY = "d"
object WeatherConverter {
    fun fromNetwork(it: YandexWeatherResponse): List<Weather> {
        val result = ArrayList<Weather>()
        val currentTime =
                if (DAY == it.fact.daytime) {
                    TypeTime.DAY
                } else {
                    TypeTime.NIGHT
                }
        result.add(Weather(it.fact.temp, it.fact.windSpeed, it.fact.feelsLike, it.fact.icon, it.fact.condition, it.fact.windDir, it.fact.pressure, it.fact.obsTime, currentTime, true))
        it.forecast.forEach {
            if (it.parts.dayShort != null) {
                val day = it.parts.dayShort
                result.add(Weather(day.temp, day.windSpeed, day.feelsLike, day.icon, day.condition, day.windDir, day.pressure, it.date, TypeTime.DAY, false))
            }
            if (it.parts.nightShort != null) {
                val night = it.parts.nightShort
                result.add(Weather(night.temp, night.windSpeed, night.feelsLike, night.icon, night.condition, night.windDir, night.pressure, it.date, TypeTime.NIGHT, false))
            }
        }
        return result
    }
}