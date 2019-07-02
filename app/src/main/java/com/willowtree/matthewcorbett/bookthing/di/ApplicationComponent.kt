package com.willowtree.matthewcorbett.bookthing.di

import com.willowtree.matthewcorbett.bookthing.ui.landing.LandingFragment
import com.willowtree.matthewcorbett.bookthing.ui.landing.LandingViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(landingFragment: LandingFragment)
    fun inject(landingViewModel: LandingViewModel)
}