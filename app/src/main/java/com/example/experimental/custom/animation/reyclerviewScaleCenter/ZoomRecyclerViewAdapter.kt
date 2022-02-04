package com.example.experimental.custom.animation.reyclerviewScaleCenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.databinding.ItemNumberBinding

class ZoomRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: ArrayList<Int> = ArrayList()

    init {
        for(i in 1..20){
            list.add(i)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ZoomRecyclerViewHolder(ItemNumberBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ZoomRecyclerViewHolder).bind(list[position].toString())
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ZoomRecyclerViewHolder(private val binding: ItemNumberBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(str: String){
            binding.tv.text = str
        }
    }
}