package com.example.experimental.liveDataRecyclerView.viewholder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.databinding.RecyclerViewViewHolderBinding
import com.example.experimental.liveDataRecyclerView.adapter.TextAdapter
import com.example.experimental.liveDataRecyclerView.viewmodel.TextViewModel

class RecyclerViewViewholder(val binding: RecyclerViewViewHolderBinding, val viewmodel: TextViewModel, val lifecycleOwner: LifecycleOwner, val onClick: () -> Unit): RecyclerView.ViewHolder(binding.root){
    fun bind(){
        val adapter = TextAdapter(viewmodel = viewmodel, lifecycleOwner = lifecycleOwner, onClick)
        val layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter

        viewmodel.text.observe(lifecycleOwner,{
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }
}