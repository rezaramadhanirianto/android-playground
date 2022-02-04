package com.example.experimental.di

import android.content.Context
import com.example.navigation.NavConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideNavConstant(@ApplicationContext context: Context): NavConstant {
        return NavConstant(context)
    }
}