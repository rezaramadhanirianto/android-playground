package com.example.experimental.custom.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experimental.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}