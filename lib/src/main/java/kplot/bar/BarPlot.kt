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
            Bar()
            Bar()
            Bar()
        }
    ) {
        measurables, constraints ->

        val barCount = measurables.size
        val barMinThicknessPercentage = 0.05
        val barMaxThicknessPercentage = 0.2
        val placeables = measurables.map {
            it.measure(
                Constraints(
                    minWidth = ((constraints.minWidth / barCount) * barMinThicknessPercentage).toInt(),
                    maxWidth = ((constraints.maxWidth / barCount) * barMaxThicknessPercentage).toInt(),
                    minHeight = constraints.minHeight,
                    maxHeight = constraints.maxHeight
                )
            )
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                it.place(0, 0)
            }
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot()
}