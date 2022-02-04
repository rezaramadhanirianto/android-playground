package com.example.experimental.liveDataRecyclerView.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel: ViewModel() {
    val _text: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val text: LiveData<ArrayList<String>>
        get() = _text
    fun add(str: String){
        val list = ArrayList(_text.value ?: listOf("FIRST"))
        list.add(str)
        _text.value = list
    }
}