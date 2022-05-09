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
        val barMinThicknessPercentage = 0.125
        val barMaxThicknessPercentage = 0.15
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
            val divider = if(barCount == 1) 1 else barCount - 1
            // x coordinate where item needs to be placed
            var x = 0
            placeables.forEachIndexed { i, p ->
                // y coordinate where item needs to be placed
                val y = constraints.maxHeight - p.height

                val itemWidthOffset = (p.width * (i.toFloat()/ divider)).toInt()

                // the x & y coordinates are the top left corner of the item
                // item width is subtracted from x coordinate to left shift and fit the items
                p.place(x - itemWidthOffset, y)

                x += constraints.maxWidth / divider
            }
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot(
        barPlotData = BarPlotData(floatArrayOf(1f, 4f, 2f, 5f))
    )
}
