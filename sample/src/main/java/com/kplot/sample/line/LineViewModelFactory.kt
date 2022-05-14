package com.kplot.sample.line

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LineViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LineViewModel::class.java)) {
            return LineViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}