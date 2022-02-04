package com.example.experimental.custom.animation.reyclerviewScaleCenter

import ScaleLayoutManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experimental.databinding.FragmentRecyclerViewScaleCenterBinding

class RecyclerViewScaleCenterFragment : Fragment() {

    private var _binding: FragmentRecyclerViewScaleCenterBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewScaleCenterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val adapter = ZoomRecyclerViewAdapter()
//        binding.rv.layoutManager = ZoomLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val manager = ScaleLayoutManager(context = requireContext(), LinearLayoutManager.HORIZONTAL, false).setScaleOnScroll(true)
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapter
    }
}