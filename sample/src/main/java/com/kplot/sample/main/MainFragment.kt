package com.kplot.sample.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kplot.sample.navigation.Destination
import com.kplot.sample.navigation.navigate
import com.kplot.sample.ui.theme.KplotTheme
import kplot.bar.BarPlot
import kplot.barplot.BarPlotJustification
import kplot.barplot.BarPlotStyle
import kplot.line.LinePlot

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }
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
                        TestSampleComposable(viewModel)
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

@Composable
fun TestSampleComposable(viewModel: MainViewModel) {
    Text("Hello kplot sample Composable", color = MaterialTheme.colors.onBackground)
    Button(onClick = { viewModel.navigateTo(Destination.CUSTOM) }) {
        Text(text = "Custom Chart")
    }
    Button(onClick = { viewModel.navigateTo(Destination.BAR) }) {
        Text(text = "Bar Chart")
    }
    val data = floatArrayOf(1f, 4f, 2f, 3f)
    LazyColumn(content = {
        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 1.dp) {
                LinePlot(data,
                    modifier = Modifier.padding(16.dp))
            }
        }
    })
}