package com.kplot.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.kplot.sample.ui.theme.KplotTheme
import kplot.bar.BarPlot
import kplot.barplot.BarPlotJustification
import kplot.barplot.BarPlotStyle

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
    BarPlot(floatArrayOf(1f, 3f, 2f),
        barPlotStyle = BarPlotStyle.PACKED,
        barPlotJustification = BarPlotJustification.CENTER)
}
