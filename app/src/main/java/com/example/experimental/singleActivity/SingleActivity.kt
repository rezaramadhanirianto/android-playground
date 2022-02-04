package com.example.experimental.singleActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.experimental.R
import com.example.experimental.databinding.ActivitySingleBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class SingleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }



    private fun findNavController(): NavController{
        return (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }
}