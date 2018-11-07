package ru.ertelecom.testapplication.domain.model

enum class TypeTime {
    DAY {
        override fun isDay() = true
    },
    NIGHT {
        override fun isDay() = false
    };

    abstract fun isDay(): Boolean
}