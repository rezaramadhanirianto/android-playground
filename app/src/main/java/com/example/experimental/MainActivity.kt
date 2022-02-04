package com.example.experimental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experimental.databinding.ActivityMainBinding
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.example.experimental.custom.pref.LocaleHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentLang = "in"

    val KEY = "LOCALE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        this.lifecycleScope.launch(Dispatchers.IO){

        }

        binding.btn.setOnClickListener {
            LocaleHelper.setLocale(this, currentLang)

            finish()
            startActivity(Intent(this, SplashActivity::class.java))
        }
    }

}