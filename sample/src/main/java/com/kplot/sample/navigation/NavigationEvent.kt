package com.kplot.sample.navigation

sealed class NavigationEvent {
    data class NavigateTo(val dest: Destination) : NavigationEvent()
    object OnBack: NavigationEvent()
}