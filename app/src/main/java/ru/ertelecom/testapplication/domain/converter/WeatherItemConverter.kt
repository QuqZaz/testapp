package ru.ertelecom.testapplication.domain.converter

import ru.ertelecom.testapplication.domain.extension.DateUtils
import ru.ertelecom.testapplication.domain.model.Weather
import ru.ertelecom.testapplication.domain.model.WeatherItem

object WeatherItemConverter {
    fun fromNetwork(it: Weather): WeatherItem {
        return WeatherItem("https://yastatic.net/weather/i/icons/blueye/color/svg/${it.icon}.svg",
                DateUtils.toSimpleString(it.obsTime),
                "${it.temp} °C",
                it.typeTime.isDay()
        )
    }
}