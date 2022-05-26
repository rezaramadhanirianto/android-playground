package com.example.experimental.lib.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experimental.R
import com.example.experimental.databinding.ActivityEpoxyRecyclerViewBinding

class EpoxyRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityEpoxyRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEpoxyRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        println("TAG: MASUK")
    }

    private fun setupView(){
        val controller = NumberViewController()
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.setItemSpacingDp(8)
        binding.rv.setController(controller)
        controller.setTitle("asdf")
    }
}