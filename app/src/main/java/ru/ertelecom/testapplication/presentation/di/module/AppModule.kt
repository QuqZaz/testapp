package ru.ertelecom.testapplication.presentation.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.ertelecom.testapplication.data.repository.WeatherDataRepository
import ru.ertelecom.testapplication.domain.repository.WeatherRepository
import ru.ertelecom.testapplication.domain.usecase.WeatherUseCase
import ru.ertelecom.testapplication.presentation.presentation.presenter.MainPresenter
import javax.inject.Singleton


@Module
class AppModule(val context: Context) {

    @Provides
    fun providesWeatherRepository(): WeatherRepository = WeatherDataRepository()


    @Provides
    @Singleton
    fun providersWeatherUseCase(repository: WeatherRepository): WeatherUseCase {
        return WeatherUseCase(repository)
    }

    @Provides
    fun providersMainPresenter(useCase: WeatherUseCase): MainPresenter {
        return MainPresenter(useCase)
    }
}