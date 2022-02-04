package com.example.experimental.singleActivity.modules.list.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.experimental.singleActivity.data.common.models.Movie

object ListDiffUtil: DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

}