package ru.ertelecom.testapplication.data.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.ertelecom.testapplication.data.network.model.YandexWeatherResponse

const val API_KEY = "X-Yandex-API-Key: 182247e0-93ed-4676-9361-bb6ae756a4f0"

interface YandexRestApi {

    @GET("forecast")
    @Headers(API_KEY)
    fun getWeather(@Query("lat") lat: Float, @Query("lon") lon: Float, @Query("limit") limit: Int): Single<YandexWeatherResponse>
}