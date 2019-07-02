package com.willowtree.matthewcorbett.bookthing.di

import com.willowtree.matthewcorbett.bookthing.landing.LandingViewModel
import com.willowtree.matthewcorbett.bookthing.landing.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(landingViewModel: LandingViewModel)
}