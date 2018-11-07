package ru.ertelecom.testapplication.presentation

import android.app.Application
import ru.ertelecom.testapplication.presentation.di.components.AppComponent
import ru.ertelecom.testapplication.presentation.di.components.DaggerAppComponent
import ru.ertelecom.testapplication.presentation.di.module.AppModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}