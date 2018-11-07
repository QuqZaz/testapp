package ru.ertelecom.testapplication.domain.usecase

import io.reactivex.Single
import ru.ertelecom.testapplication.domain.converter.WeatherItemConverter
import ru.ertelecom.testapplication.domain.extension.schedulersIoToMain
import ru.ertelecom.testapplication.domain.model.WeatherItem
import ru.ertelecom.testapplication.domain.repository.WeatherRepository

const val LAT = 59.915188f
const val LOT = 56.140517f
const val LIMIT = 2

class WeatherUseCase(
        val repository: WeatherRepository
) {
    fun getWeather(): Single<List<WeatherItem>> {
        return repository
                .getWeather(LAT, LOT, LIMIT)
                .toObservable()
                .flatMapIterable { list -> list }
                .map { WeatherItemConverter.fromNetwork(it) }
                .toList()
                .toMaybe()
                .toSingle()
                .schedulersIoToMain()
    }
}