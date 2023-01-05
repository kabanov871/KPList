package com.example.kplist.presentation

import android.app.Application
import com.example.kplist.di.DaggerApplicationComponent

class MyApp: Application() {

    val component by lazy {

        DaggerApplicationComponent.factory().create(this)
    }
}