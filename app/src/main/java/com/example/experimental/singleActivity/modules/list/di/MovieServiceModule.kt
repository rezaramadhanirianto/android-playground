package com.example.experimental.singleActivity.modules.list.di

import com.example.experimental.singleActivity.modules.list.data.remote.service.MovieService
import com.example.experimental.singleActivity.modules.list.data.remote.source.IMovieDataSource
import com.example.experimental.singleActivity.modules.list.data.remote.source.MovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object MovieServiceModule {

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService{
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideMovieDataSource(movieDataSource: MovieDataSource): IMovieDataSource {
        return movieDataSource
    }
}