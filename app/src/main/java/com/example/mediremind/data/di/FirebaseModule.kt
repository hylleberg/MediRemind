package com.example.mediremind.data.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFireStoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

}