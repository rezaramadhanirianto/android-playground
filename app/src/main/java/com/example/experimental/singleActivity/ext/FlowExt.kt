package com.example.experimental.singleActivity.ext

import com.example.experimental.singleActivity.utils.Resources
import kotlinx.coroutines.flow.Flow

fun <T> Flow<Resources<List<T>>>.toList(): List<T> {
    return toList()
}