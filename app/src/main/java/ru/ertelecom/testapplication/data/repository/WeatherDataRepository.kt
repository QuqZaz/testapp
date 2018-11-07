package ru.ertelecom.testapplication.data.repository

import io.reactivex.Single
import ru.ertelecom.testapplication.data.converter.WeatherConverter
import ru.ertelecom.testapplication.data.network.api.YandexApiFactory
import ru.ertelecom.testapplication.domain.model.Weather
import ru.ertelecom.testapplication.domain.repository.WeatherRepository

class WeatherDataRepository : WeatherRepository {
    override fun getWeather(lat: Float, lot: Float, limit: Int): Single<List<Weather>> {
        return YandexApiFactory.api
                .getWeather(lat, lot, limit)
                .map { WeatherConverter.fromNetwork(it) }
    }

}
