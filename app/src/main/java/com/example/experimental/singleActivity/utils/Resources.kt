package com.example.experimental.singleActivity.utils

sealed class Resources<out T>(val data: T? = null, val message: String? = null, val code: Int? = null) {
    class Success<T>(data: T?): Resources<T>(data)
    class Loading: Resources<Nothing>()
    class Error(message: String? = null, code: Int? = null): Resources<Nothing>(message = message, code = code)
}