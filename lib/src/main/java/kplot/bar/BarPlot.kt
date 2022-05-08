package kplot.bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints

/**
 * A compose function that plots [Bar]s
 */
@Composable
fun BarPlot(modifier: Modifier = Modifier) {
    Layout(
        modifier = Modifier,
        content = {
            repeat(5) {
                Bar()
            }
        }
    ) { measurables, constraints ->

        val barCount = measurables.size
        val barMinThicknessPercentage = 0.01
        val barMaxThicknessPercentage = 0.05
        val placeables = measurables.map {
            it.measure(
                Constraints(
                    minWidth = (constraints.minWidth * barMinThicknessPercentage).toInt(),
                    maxWidth = (constraints.maxWidth * barMaxThicknessPercentage).toInt(),
                    minHeight = constraints.minHeight,
                    maxHeight = constraints.maxHeight
                )
            )
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var xOffset = 0
            placeables.forEach {
                val itemWidth = it.width / 2
                xOffset += constraints.maxWidth / (barCount + 1)
                it.place(xOffset - itemWidth, 0)
            }
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot()
}