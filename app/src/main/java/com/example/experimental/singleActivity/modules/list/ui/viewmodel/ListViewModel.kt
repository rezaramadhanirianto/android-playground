package com.example.experimental.singleActivity.modules.list.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.modules.list.data.remote.repository.IMovieRepository
import com.example.experimental.singleActivity.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val repo: IMovieRepository) : ViewModel() {

    private var _popularMovies= MutableLiveData<PagingData<Movie>>()
    val movies: LiveData<PagingData<Movie>> = _popularMovies

    init {
        getPopularMovies(1)
    }

    fun getPopularMovies(page: Long) {
        viewModelScope.launch {
            repo.getPopularMovie(page).collect {
                _popularMovies.value = it
            }
        }
    }
}