package com.example.experimental.configurationChanges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.experimental.databinding.ActivityConfigurationChangesBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class ConfigurationChangesActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityConfigurationChangesBinding
    var time :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConfigurationChangesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        attachTime()

        lifecycleScope.launch(Dispatchers.IO) {
            timer().collect {
                withContext(Dispatchers.Main){
                    binding.tv.text = it.toString()
                }
            }
        }

        println("LIFECYCLE: OnCreate")
    }

    private fun attachTime(){
        val newTime = lastCustomNonConfigurationInstance as Int?
        if(newTime != null){
            time = newTime
        }
    }

    private suspend fun timer(): Flow<Int> {
        return flow {
            while(time < 500){
                delay(1000)
                emit(time)
                time++
            }
        }
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return time
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("time", time)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        time = savedInstanceState.getInt("time", 0)
    }

    override fun onStart() {
        super.onStart()

        println("LIFECYCLE: OnStart")
    }

    override fun onResume() {
        super.onResume()

        println("LIFECYCLE: OnResume")
    }

    override fun onPause() {
        super.onPause()

        println("LIFECYCLE: OnPause")
    }

    override fun onStop() {
        super.onStop()

        println("LIFECYCLE: OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        println("LIFECYCLE: OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()

        println("LIFECYCLE: OnRestart")
    }

}