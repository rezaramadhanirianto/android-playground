package com.example.experimental.liveDataRecyclerView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experimental.custom.transition.SecondActivity
import com.example.experimental.databinding.ActivityRecyclerViewBinding
import com.example.experimental.liveDataRecyclerView.adapter.RecyclerViewAdapter
import com.example.experimental.liveDataRecyclerView.viewmodel.TextViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: RecyclerViewAdapter
    val viewmodel: TextViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(binding.root)

        setViewModel()
        initView()
    }

    private fun setViewModel() {
        lifecycleScope.launch {
            for(i in 1..100){
                delay(3000)
                viewmodel.add("GO: ${Math.random()}")
            }
        }
    }

    private fun initView(){
        adapter = RecyclerViewAdapter(viewmodel = viewmodel, lifecycleOwner = this){
            startActivity(Intent(this, SecondActivity::class.java))
        }
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter
    }


}