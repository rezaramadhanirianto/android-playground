package com.example.experimental.custom.transition

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import com.example.experimental.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.lytParent.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,  Pair(binding.img, "img"), Pair(binding.title, "title"), Pair(binding.lytParent, "lytParent"))
            startActivity(intent, options.toBundle())
        }
    }


}