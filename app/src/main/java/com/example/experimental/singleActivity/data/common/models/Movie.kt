package com.example.experimental.singleActivity.data.common.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("poster_path")
    var posterPath: String,
    val id: Long,

    @SerializedName("original_title")
    var title: String,

    @SerializedName("release_date")
    val description: String,
    val popularity: Double,
    val overview: String,
)