package ru.ertelecom.testapplication.presentation.di.components

import dagger.Component
import ru.ertelecom.testapplication.presentation.App
import ru.ertelecom.testapplication.presentation.di.module.AppModule
import ru.ertelecom.testapplication.presentation.ui.activity.MainActivity
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}