package com.example.mycaffeine

import android.app.Application
import com.example.mycaffeine.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyCaffeineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyCaffeineApplication)
            modules(appModule)
        }
    }
}