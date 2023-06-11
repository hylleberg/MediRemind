package com.example.mediremind.data.di

import com.example.mediremind.data.repo.PatientRepository
import com.example.mediremind.data.repo.PatientRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePatientRepository(
        database: FirebaseFirestore
    ): PatientRepository{
        return PatientRepositoryImpl(database)
    }
}