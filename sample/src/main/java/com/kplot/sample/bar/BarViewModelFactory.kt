package com.kplot.sample.bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BarViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BarViewModel::class.java)) {
            return BarViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}