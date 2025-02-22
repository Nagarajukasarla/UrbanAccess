package com.example.buspassapplication.models

import com.example.buspassapplication.models.implementation.PassServiceImplementation
import com.example.buspassapplication.models.service.PassService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PassViewModel {
    @Binds
    abstract fun providePassService(impl: PassServiceImplementation): PassService
}