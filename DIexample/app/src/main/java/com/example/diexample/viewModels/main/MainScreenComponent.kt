package com.example.diexample.viewModels.main

import androidx.lifecycle.ViewModel
import com.example.diexample.DI
import com.example.diexample.di.ScreenScope
import com.example.diexample.di.ViewModelFactory
import com.example.diexample.di.ViewModelKey
import com.example.diexample.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [MainScreenModule::class])
@ScreenScope
interface MainScreenComponent {

    fun viewModelFactory() : ViewModelFactory

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun resources(resourceProvider: ResourceProvider) : Builder
        fun build() : MainScreenComponent
    }

    companion object {
        fun create() = with(DI.appComponent){
            DaggerMainScreenComponent.builder()
                .resources(resources())
                .build()
        }
    }

}

@Module
abstract class MainScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun mainScreenViewModel(viewModel: MainScreenViewModel) : ViewModel


}