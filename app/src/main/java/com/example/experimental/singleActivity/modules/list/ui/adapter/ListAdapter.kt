package com.example.experimental.singleActivity.modules.list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.experimental.databinding.ItemMovieBinding
import com.example.experimental.singleActivity.data.common.models.Movie
//import com.example.experimental.singleActivity.modules.list.ui.ItemMovie
import javax.inject.Inject

class ListAdapter @Inject constructor() : PagingDataAdapter<Movie, MovieViewHolder>(ListDiffUtil) {
    var onClick: () -> Unit = {}

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, onClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    fun changeUI(){
        getItem(0)?.let {
            it.title = "asdfadsfadsfadsf"
        }
        notifyDataSetChanged()
    }
}

class MovieViewHolder(private val  binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: Movie, onClick: () -> Unit){
        movie.posterPath = "https://image.tmdb.org/t/p/w500/${movie.posterPath}"
        binding.tvName.text = movie.title
//        binding.myComposable.setContent {
//            ItemMovie(movie = movie)
//        }
//        binding.myComposable.setOnClickListener {
//            onClick()
//        }
    }
}