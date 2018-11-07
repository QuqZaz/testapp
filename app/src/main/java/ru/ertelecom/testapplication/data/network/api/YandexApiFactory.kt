package ru.ertelecom.testapplication.data.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_BASE_URL = "https://api.weather.yandex.ru/v1/"

object YandexApiFactory {
    val api = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(YandexRestApi::class.java)

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }
}