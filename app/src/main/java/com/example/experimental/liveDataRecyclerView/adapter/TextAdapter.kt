package com.example.experimental.liveDataRecyclerView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.databinding.ItemTextBinding
import com.example.experimental.liveDataRecyclerView.viewholder.TextViewHolder
import com.example.experimental.liveDataRecyclerView.viewmodel.TextViewModel

class TextAdapter(val viewmodel: TextViewModel, val lifecycleOwner: LifecycleOwner, val onClick: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TextViewHolder(ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false), viewmodel, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TextViewHolder).bind(list[position], onClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}