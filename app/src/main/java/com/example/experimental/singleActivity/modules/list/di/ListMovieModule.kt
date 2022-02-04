package com.example.experimental.singleActivity.modules.list.di

import com.example.experimental.singleActivity.modules.list.data.remote.repository.IMovieRepository
import com.example.experimental.singleActivity.modules.list.data.remote.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ListMovieModule {

    @Provides
    fun provideRepository(movieRepository: MovieRepository): IMovieRepository{
        return movieRepository
    }
}