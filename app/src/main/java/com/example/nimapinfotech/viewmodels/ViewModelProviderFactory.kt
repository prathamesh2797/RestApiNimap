package com.example.nimapinfotech.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nimapinfotech.repository.jsonRepository

class ViewModelProviderFactory(private val repository: jsonRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}