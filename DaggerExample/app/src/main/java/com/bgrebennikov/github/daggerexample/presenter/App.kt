package com.bgrebennikov.github.daggerexample.presenter

import android.app.Application
import com.bgrebennikov.github.daggerexample.di.DaggerAppComponent

class App : Application() {

    val component by lazy{
        DaggerAppComponent.create()
    }

}