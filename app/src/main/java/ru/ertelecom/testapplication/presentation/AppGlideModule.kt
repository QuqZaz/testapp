package ru.ertelecom.testapplication.presentation

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class AppGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled() = false
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setLogLevel(Log.DEBUG)
        super.applyOptions(context, builder)
    }
}