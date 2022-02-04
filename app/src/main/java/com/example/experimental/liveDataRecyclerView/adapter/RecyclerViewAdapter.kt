package com.example.experimental.liveDataRecyclerView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.databinding.RecyclerViewViewHolderBinding
import com.example.experimental.liveDataRecyclerView.viewholder.RecyclerViewViewholder
import com.example.experimental.liveDataRecyclerView.viewmodel.TextViewModel

class RecyclerViewAdapter(val viewmodel: TextViewModel, val lifecycleOwner: LifecycleOwner, val onClick: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecyclerViewViewholder(RecyclerViewViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false), viewmodel, lifecycleOwner, onClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecyclerViewViewholder).bind()
    }

    override fun getItemCount(): Int {
        return 1
    }


}