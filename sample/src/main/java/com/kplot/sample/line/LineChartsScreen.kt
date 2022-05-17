package com.kplot.sample.line

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kplot.config.color
import kplot.config.lineChartConfig
import kplot.data.dataSetOf
import kplot.line.LinePlot

@Composable
fun LineChartsScreen(viewModel: LineViewModel) {
    Text("Line charts", color = MaterialTheme.colors.onBackground)
    BackHandler {
        viewModel.onBack()
    }

    val data = dataSetOf(1, 4, 2, 5)
    LazyColumn(content = {
        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 1.dp) {
                LinePlot(data,
                    modifier = Modifier.padding(16.dp),
                config = lineChartConfig().color(MaterialTheme.colors.primary))
            }
        }
    })
}