package com.kplot.sample.main

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.kplot.sample.navigation.Destination

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Text("Hello kplot sample Composable", color = MaterialTheme.colors.onBackground)
    Button(onClick = { viewModel.navigateTo(Destination.CUSTOM) }) {
        Text(text = "Custom Chart")
    }
    Button(onClick = { viewModel.navigateTo(Destination.BAR) }) {
        Text(text = "Bar Chart")
    }
    Button(onClick = { viewModel.navigateTo(Destination.LINE) }) {
        Text(text = "Line Chart")
    }
}