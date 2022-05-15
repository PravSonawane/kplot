package com.kplot.sample.bar

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
import kplot.bar.BarPlot
import kplot.barplot.BarPlotJustification
import kplot.barplot.BarPlotStyle
import kplot.data.dataSetOf

@Composable
fun BarChartsScreen(viewModel: BarViewModel) {
    Text("Bar charts", color = MaterialTheme.colors.onBackground)
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
                BarPlot(data,
                    modifier = Modifier.padding(16.dp),
                    style = BarPlotStyle.PACKED,
                    justification = BarPlotJustification.START)
            }
        }

        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 1.dp) {
                BarPlot(data,
                    modifier = Modifier.padding(16.dp),
                    style = BarPlotStyle.PACKED,
                    justification = BarPlotJustification.CENTER)
            }
        }

        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 1.dp) {
                BarPlot(data,
                    modifier = Modifier.padding(16.dp),
                    style = BarPlotStyle.PACKED,
                    justification = BarPlotJustification.END)
            }
        }

        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
                elevation = 1.dp) {
                BarPlot(data,
                    modifier = Modifier.padding(16.dp),
                    style = BarPlotStyle.SPREAD)
            }
        }
    })
}