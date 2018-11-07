package ru.ertelecom.testapplication.presentation.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.ertelecom.testapplication.domain.model.WeatherItem

interface MainView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setWeather(it: List<WeatherItem>?)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProgress(it: Boolean)
}