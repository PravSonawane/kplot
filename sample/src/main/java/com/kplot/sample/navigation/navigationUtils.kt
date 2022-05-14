package com.kplot.sample.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kplot.sample.R
import com.kplot.sample.livedata.LiveDataWrapper

fun Fragment.navigate(to: LiveDataWrapper<NavigationEvent>) {
    val content = to.getContentIfNotHandled() ?: return

    if (content is NavigationEvent.NavigateTo) {
        when (content.dest) {
            Destination.MAIN -> {
                findNavController().navigate(R.id.main_fragment)
            }
            Destination.CUSTOM -> {
                findNavController().navigate(R.id.custom_fragment)
            }
            Destination.BAR -> {
                findNavController().navigate(R.id.bar_fragment)
            }
            Destination.LINE -> {
                findNavController().navigate(R.id.line_fragment)
            }
        }
    } else if (content is NavigationEvent.OnBack) {
        findNavController().popBackStack()
    }
}