package com.kplot.sample.line

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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kplot.sample.navigation.navigate
import com.kplot.sample.ui.theme.KplotTheme
import kplot.line.LinePlot

class LineFragment : Fragment() {
    private val viewModel: LineViewModel by viewModels { LineViewModelFactory() }

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
                        SampleComposable(viewModel)
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
fun SampleComposable(viewModel: LineViewModel) {
    Text("Line charts", color = MaterialTheme.colors.onBackground)
    BackHandler {
        viewModel.onBack()
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