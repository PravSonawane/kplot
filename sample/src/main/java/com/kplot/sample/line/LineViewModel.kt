package com.kplot.sample.line

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kplot.sample.livedata.LiveDataWrapper
import com.kplot.sample.navigation.Destination
import com.kplot.sample.navigation.NavigationEvent

class LineViewModel : ViewModel() {
    private val _navigateTo = MutableLiveData<LiveDataWrapper<NavigationEvent>>()
    val navigateTo: LiveData<LiveDataWrapper<NavigationEvent>>
        get() = _navigateTo

    fun navigateTo(destination: Destination) {
        _navigateTo.value = LiveDataWrapper(NavigationEvent.NavigateTo(destination))
    }

    fun onBack() {
        _navigateTo.value = LiveDataWrapper(NavigationEvent.OnBack)
    }
}