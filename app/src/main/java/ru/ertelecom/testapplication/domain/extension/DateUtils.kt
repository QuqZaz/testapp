package ru.ertelecom.testapplication.domain.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    fun toSimpleString(date: Long): String {
        val format = SimpleDateFormat("dd.MM.yyy")
        return format.format(Date(date * 1000))
    }
}