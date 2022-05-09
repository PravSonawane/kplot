package kplot.bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import kplot.data.BarPlotData

/**
 * A compose function that plots [Bar]s
 */
@Suppress("MagicNumber")
@Composable
fun BarPlot(barPlotData: BarPlotData, modifier: Modifier = Modifier) {
    val maxData = barPlotData.values.maxOrNull() ?: 1f
    Layout(
        modifier = Modifier,
        content = {
            repeat(barPlotData.values.size) {
                Bar()
            }
        }
    ) { measurables, constraints ->

        val barCount = measurables.size
        val barMinThicknessPercentage = 0.01
        val barMaxThicknessPercentage = 0.05
        val placeables = measurables.mapIndexed { i, p ->
            p.measure(
                Constraints(
                    minWidth = (constraints.minWidth * barMinThicknessPercentage).toInt(),
                    maxWidth = (constraints.maxWidth * barMaxThicknessPercentage).toInt(),
                    minHeight = constraints.minHeight,
                    maxHeight = (constraints.maxHeight * (barPlotData.values[i] / maxData)).toInt()
                )
            )
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var x = 0
            placeables.forEach {
                // mid point of the item width
                val itemWidthMid = it.width / 2
                // y coordinate where item needs to be placed
                val y = constraints.maxHeight - it.height

                x += constraints.maxWidth / (barCount + 1)
                it.place(x - itemWidthMid, y)
            }
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot(
        barPlotData = BarPlotData(floatArrayOf(1f, 7f, 2f))
    )
}
