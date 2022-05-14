package com.kplot.sample.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kplot.sample.navigation.navigate
import com.kplot.sample.ui.theme.KplotTheme

class CustomFragment : Fragment() {
    private val viewModel: CustomViewModel by viewModels { CustomViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        handleNavigationEvents()

        return ComposeView(requireContext()).apply {
            setContent {
                KplotTheme {
                    Column {
                        CustomChartScreen(viewModel)
                    }
                }
            }
        }
    }

    private fun handleNavigationEvents() {
        viewModel.navigateTo.observe(viewLifecycleOwner) { navigateToEvent ->
            this.navigate(navigateToEvent)
        }
    }
}

