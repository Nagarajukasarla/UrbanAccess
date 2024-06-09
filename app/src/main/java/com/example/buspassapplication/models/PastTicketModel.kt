package com.example.buspassapplication.models

import com.example.buspassapplication.models.implementation.PastTicketServiceImplementation
import com.example.buspassapplication.models.implementation.TransactionServiceImplementation
import com.example.buspassapplication.models.service.PastTicketService
import com.example.buspassapplication.models.service.TransactionService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PastTicketModel {
    @Binds
    abstract fun provideTransactionService(impl: PastTicketServiceImplementation): PastTicketService
}
