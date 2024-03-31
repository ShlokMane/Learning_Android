package com.example.weatheapp.di

import com.example.weatheapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Module::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}
