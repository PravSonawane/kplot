package com.kplot.sample.custom

import androidx.activity.compose.BackHandler
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomChartScreen(viewModel: CustomViewModel) {
    Text("Hello custom screen", color = MaterialTheme.colors.onBackground)
    BackHandler {
        viewModel.onBack()
    }
}