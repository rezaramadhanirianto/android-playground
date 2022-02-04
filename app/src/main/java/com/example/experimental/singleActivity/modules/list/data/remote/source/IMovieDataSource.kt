package com.example.experimental.singleActivity.modules.list.data.remote.source

import androidx.paging.PagingData
import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.utils.Resources
import kotlinx.coroutines.flow.Flow

interface IMovieDataSource {
    suspend fun getPopularMovies(page: Long) : Flow<PagingData<Movie>>
}