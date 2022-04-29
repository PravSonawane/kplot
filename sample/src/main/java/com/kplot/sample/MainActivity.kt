package com.kplot.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.kplot.plot.TestLibComposable
import com.kplot.sample.ui.theme.KplotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KplotTheme {
                Column {
                    TestSampleComposable()
                    TestLibComposable()
                }
            }
        }
    }
}

@Composable
fun TestSampleComposable() {
    Text("Hello kplot sample Composable")
}
