package com.example.experimental.singleActivity.modules.list.data.remote.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.modules.list.data.remote.pagingSource.ListPagingDataSource
import com.example.experimental.singleActivity.modules.list.data.remote.service.MovieService
import com.example.experimental.singleActivity.utils.BaseCall
import com.example.experimental.singleActivity.utils.Resources
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDataSource @Inject constructor (val service: MovieService, val apiKey: String): IMovieDataSource{
    override suspend fun getPopularMovies(page: Long): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ListPagingDataSource(service, apiKey)
            }
        ).flow
    }
}