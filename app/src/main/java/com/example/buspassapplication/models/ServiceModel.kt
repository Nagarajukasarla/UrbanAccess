package com.example.buspassapplication.models

import com.example.buspassapplication.models.implementation.AccountServiceImplementation
import com.example.buspassapplication.models.service.AccountService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModel {
    @Binds abstract fun provideAccountService(impl: AccountServiceImplementation): AccountService
}