package com.carlyadam.arquitecture

import android.app.Application
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.di.AppModule.bookModule
import com.carlyadam.arquitecture.di.AppModule.webServiceModule
import org.acra.ReportingInteractionMode
import org.acra.annotation.ReportsCrashes
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


@ReportsCrashes(
    mailTo = "carlyadam88@gmail.com",
    mode = ReportingInteractionMode.TOAST,
    resToastText = R.string.crash_text
)
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = listOf(webServiceModule, bookModule)
        startKoin {
            androidContext(this@BaseApplication)
            modules(appComponent)
        }
        // ACRA.init(this)
    }


}