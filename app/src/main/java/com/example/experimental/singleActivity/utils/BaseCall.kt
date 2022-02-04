package com.example.experimental.singleActivity.utils

import com.bumptech.glide.load.HttpException
import com.bumptech.glide.load.engine.Resource
import com.example.experimental.singleActivity.data.common.remote.Responses
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

object BaseCall{
    @Suppress("UNCHECKED_CAST")
    suspend fun <T, V> call(dispatcher: CoroutineDispatcher = Dispatchers.IO, apiCall: suspend() ->  Response<T>): Flow<Resources<V>> {
        return flow{
            emit(Resources.Loading())
            try {
                val result = apiCall.invoke()
                if(result.isSuccessful){
                    if(result.body() is Responses<*>){
                        emit(Resources.Success((result.body() as Responses<*>).results as V))
                    }
                }else{
                    emit(Resources.Error(result.message()))
                }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> emit(Resources.Error(throwable.message))
                    is HttpException -> {
                        emit(Resources.Error(throwable.message))
                    }
                    else -> {
                        emit(Resources.Error(throwable.message))
                    }
                }
            }
        }.flowOn(dispatcher)
    }


    @Suppress("UNCHECKED_CAST")
    suspend fun <T, V> callWithoutFlow(apiCall: suspend () -> Response<T>): Resources<V> {
        try {
            val result = apiCall.invoke()
            return if(result.isSuccessful){
                if(result.body() is Responses<*>)
                    Resources.Success((result.body() as Responses<*>).results as V)
                else
                    Resources.Success(result.body() as V)

            }else
                Resources.Error(result.message())

        } catch (throwable: Throwable) {
            return when (throwable) {
                is IOException -> Resources.Error(throwable.message)
                is HttpException -> Resources.Error(throwable.message)
                else -> Resources.Error(throwable.message)
            }
        }
    }
}