package com.example.experimental.custom.backgroundThread

import kotlinx.coroutines.*

object NumberCounter {
    var num = 0
    var job = Job()
    var scope = CoroutineScope(Dispatchers.IO + job)

    fun start(){
        scope.launch {
            for(i in 1..10000){
                println("NumberCounter: $num")
                delay(1000)
                num++
                if(num == 10){
                    job.cancel()
                }
            }
        }
    }

    fun stop(){
        scope.cancel()
    }
}