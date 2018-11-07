package ru.ertelecom.testapplication.domain.repository

import io.reactivex.Single
import ru.ertelecom.testapplication.domain.model.Weather

interface WeatherRepository {
    fun getWeather(lat: Float, lot: Float, limit: Int): Single<List<Weather>>
}