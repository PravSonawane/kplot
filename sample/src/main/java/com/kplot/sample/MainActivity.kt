package com.kplot.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kplot.sample.ui.theme.KplotTheme
import kplot.bar.BarPlot
import kplot.barplot.BarPlotJustification
import kplot.barplot.BarPlotStyle
import kplot.line.LinePlot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KplotTheme {
                Column {
                    TestSampleComposable()
                }
            }
        }
    }
}

@Composable
fun TestSampleComposable() {
    Text("Hello kplot sample Composable", color = MaterialTheme.colors.onBackground)

    val data = floatArrayOf(1f, 4f, 2f, 3f)
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
