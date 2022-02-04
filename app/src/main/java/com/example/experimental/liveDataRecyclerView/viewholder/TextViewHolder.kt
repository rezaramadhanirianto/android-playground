package com.example.experimental.liveDataRecyclerView.viewholder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.databinding.ItemTextBinding
import com.example.experimental.liveDataRecyclerView.viewmodel.TextViewModel

 class TextViewHolder(val binding: ItemTextBinding, val viewmodel: TextViewModel, val lifecycleOwner: LifecycleOwner): RecyclerView.ViewHolder(binding.root){
    fun bind(text: String, onClick: () -> Unit){
        viewmodel.text.observe(lifecycleOwner, {
            binding.tv.text = text
        })

        binding.tv.setOnClickListener {
            onClick()
        }


    }
}