package com.example.buspassapplication.models

import com.example.buspassapplication.models.implementation.StudentServiceImplementation
import com.example.buspassapplication.models.service.StudentService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class StudentModel {
    @Binds abstract fun provideStudentService(impl: StudentServiceImplementation): StudentService
}