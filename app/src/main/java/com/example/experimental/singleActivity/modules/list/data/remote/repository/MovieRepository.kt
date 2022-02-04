package com.example.experimental.singleActivity.modules.list.data.remote.repository

import androidx.paging.PagingData
import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.modules.list.data.remote.source.IMovieDataSource
import com.example.experimental.singleActivity.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(val movieDataSource: IMovieDataSource): IMovieRepository {
    override suspend fun getPopularMovie(page: Long): Flow<PagingData<Movie>> {
        return movieDataSource.getPopularMovies(page)
    }
}