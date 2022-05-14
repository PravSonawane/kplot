package com.kplot.sample.custom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomViewModel::class.java)) {
            return CustomViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}