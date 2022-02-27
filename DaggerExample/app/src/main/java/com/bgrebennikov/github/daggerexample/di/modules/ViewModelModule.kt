package com.bgrebennikov.github.daggerexample.di.modules

import androidx.lifecycle.ViewModel
import com.bgrebennikov.github.daggerexample.di.annotations.ViewModelKey
import com.bgrebennikov.github.daggerexample.presenter.viewModels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl : MainViewModel) : ViewModel

}