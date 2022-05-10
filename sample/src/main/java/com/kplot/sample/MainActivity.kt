package com.kplot.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.kplot.sample.MainActivity.Companion.data
import com.kplot.sample.ui.theme.KplotTheme
import kplot.bar.BarPlot
import kplot.data.BarPlotData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KplotTheme {
                Column {
                    TestSampleComposable()
                    BarPlot(data)
                }
            }
        }
    }

    companion object {
        val data = BarPlotData(floatArrayOf(4f,2f,3f,2f))
    }
}

@Composable
fun TestSampleComposable() {
    Text("Hello kplot sample Composable")
    BarPlot(data)
}
