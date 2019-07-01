package com.willowtree.matthewcorbett.bookthing

import android.app.Application
import com.willowtree.matthewcorbett.bookthing.di.ApplicationComponent
import com.willowtree.matthewcorbett.bookthing.di.ApplicationModule
import com.willowtree.matthewcorbett.bookthing.di.DaggerApplicationComponent

class BookApp: Application() {
    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
    }
}