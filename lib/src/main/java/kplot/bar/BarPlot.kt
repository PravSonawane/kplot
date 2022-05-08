package kplot.bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * A compose function that plots [Bar]s
 */
@Composable
fun BarPlot(modifier: Modifier = Modifier) {
    Bar()
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot()
}