package com.example.experimental.singleActivity.data.common.remote

import com.google.gson.annotations.SerializedName

data class Responses<T>(
    @SerializedName("total_pages") val total: Int = 0,
    val page: Int = 0,
    val results: List<T>
)