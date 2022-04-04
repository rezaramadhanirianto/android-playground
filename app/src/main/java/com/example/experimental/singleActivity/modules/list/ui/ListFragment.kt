package com.example.experimental.singleActivity.modules.list.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.experimental.R
import com.example.experimental.databinding.FragmentListBinding
import com.example.experimental.singleActivity.modules.list.ui.adapter.ListAdapter
import com.example.experimental.singleActivity.modules.list.ui.viewmodel.ListViewModel
import com.example.navigation.NavConstant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {

    val viewmodel: ListViewModel by viewModels()
    private var _binding: FragmentListBinding? =null
    private val binding get() = _binding!!

    @Inject
    lateinit var adapter: ListAdapter

    @Inject
    lateinit var navConstant: NavConstant

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupViewModel()
    }

    private fun setupViewModel(){
        viewmodel.movies.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                adapter.submitData(it)
                adapter.changeUI()
            }
        }

    }

    private fun setupView(){
        setupRecycleView()
    }

    private fun setupRecycleView(){
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter
        adapter.onClick = {
//            findNavController().navigate(ListFragmentA)
            findNavController().navigate(Uri.parse("https://cobacoba.com/listfragment")) // Use Deep Link
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
    }
}