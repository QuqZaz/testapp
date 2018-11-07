package ru.ertelecom.testapplication.presentation.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import ru.ertelecom.testapplication.domain.usecase.WeatherUseCase
import ru.ertelecom.testapplication.presentation.presentation.view.MainView


@InjectViewState
class MainPresenter(val useCase: WeatherUseCase) : MvpPresenter<MainView>() {
    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun loadData() {
        viewState.setProgress(true)
        compositeDisposable.add(useCase
                .getWeather()
                .subscribe { it, error ->
                    viewState.setWeather(it)
                    viewState.setProgress(false)
                    if (error != null) {
                        error.printStackTrace()
                    }
                })
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}