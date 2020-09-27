package com.selen.mynotes.ui

import android.app.Application
import org.koin.android.ext.android.startKoin
import com.selen.mynotes.di.appModule
import com.selen.mynotes.di.mainModule
import com.selen.mynotes.di.noteModule
import com.selen.mynotes.di.splashModule

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}

