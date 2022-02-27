package com.bgrebennikov.github.daggerexample.di

import com.bgrebennikov.github.daggerexample.di.modules.RepositoryModule
import com.bgrebennikov.github.daggerexample.di.modules.ViewModelModule
import com.bgrebennikov.github.daggerexample.presenter.ui.MainActivity
import dagger.Component


@Component(
    modules = [RepositoryModule::class, ViewModelModule::class]
)
interface AppComponent {


    fun inject(activity: MainActivity)
    
}