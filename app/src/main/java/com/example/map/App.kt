package com.example.map

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("bb16f71f-e8b1-416e-818e-01e0c0251da3")
    }
}