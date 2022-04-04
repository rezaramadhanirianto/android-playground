package com.example.experimental.custom.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.experimental.custom.service.foreground.MyForegroundService
import com.example.experimental.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnForeground.setOnClickListener {
            startService()
        }

        binding.btnStopForeground.setOnClickListener {
            stopService()
        }
    }

    fun startService() {

        val myServiceIntent = Intent(this, MyForegroundService::class.java)
        myServiceIntent.putExtra(MyForegroundService.input, "input")
        ContextCompat.startForegroundService(this, myServiceIntent)
    }

    fun stopService() {
        val serviceIntent = Intent(this, MyForegroundService::class.java)
        stopService(serviceIntent)
    }
}