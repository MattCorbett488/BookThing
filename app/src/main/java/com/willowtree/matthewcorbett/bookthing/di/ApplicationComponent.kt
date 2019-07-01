package com.willowtree.matthewcorbett.bookthing.di

import com.willowtree.matthewcorbett.bookthing.MainActivity
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}