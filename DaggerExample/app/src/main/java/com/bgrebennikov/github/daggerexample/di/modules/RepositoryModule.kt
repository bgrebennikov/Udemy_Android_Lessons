package com.bgrebennikov.github.daggerexample.di.modules

import com.bgrebennikov.github.daggerexample.data.Repository
import com.bgrebennikov.github.daggerexample.domain.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindsRepository(impl: RepositoryImpl) : Repository

}