package com.example.experimental

import android.app.Application
import com.example.experimental.custom.pref.Preference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        Preference.init(applicationContext)
    }
}