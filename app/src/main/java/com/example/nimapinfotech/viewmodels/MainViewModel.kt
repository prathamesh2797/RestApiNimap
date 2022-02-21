package com.example.nimapinfotech.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nimapinfotech.models.DataList
import com.example.nimapinfotech.repository.jsonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private var repository: jsonRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getData()
        }
    }

    val jsonData : LiveData<DataList>
        get()= repository.json
}