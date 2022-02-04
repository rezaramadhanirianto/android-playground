package com.example.experimental.singleActivity.modules.list.data.remote.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.data.common.remote.Responses
import com.example.experimental.singleActivity.modules.list.data.remote.service.MovieService
import com.example.experimental.singleActivity.utils.BaseCall
import com.example.experimental.singleActivity.utils.Resources
import kotlinx.coroutines.flow.collect
import java.lang.Exception
import javax.inject.Inject

class ListPagingDataSource @Inject constructor(val service: MovieService, val apiKey: String): PagingSource<Long, Movie>() {
    override fun getRefreshKey(state: PagingState<Long, Movie>): Long? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Movie> {
        var pageIndex = params.key ?: 1
        try{
            val response = BaseCall.call<Responses<Movie>, List<Movie>> {
                service.getPopularMovies(apiKey, pageIndex)
            }
            var movies = emptyList<Movie>()
            response.collect {
                when(it){
                    is Resources.Success -> {
                        it.data?.run {
                            movies = this
                        }
                    }
                    is Resources.Error -> { }
                    is Resources.Loading -> { }
                }
            }

            pageIndex++
            return LoadResult.Page(
                data = movies,
                prevKey = null,
                nextKey = pageIndex
            )
        } catch (exception: Exception){
            return LoadResult.Error(exception)
        }
    }
}