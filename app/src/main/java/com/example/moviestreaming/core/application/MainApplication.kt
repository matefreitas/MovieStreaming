package com.example.moviestreaming.core.application

import android.app.Application
import com.example.moviestreaming.di.RepositoryModule
import com.example.moviestreaming.di.appModules
import com.example.moviestreaming.di.firebaseModule
import com.example.moviestreaming.di.presenterModule
import com.example.moviestreaming.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModules)
        }
    }
}