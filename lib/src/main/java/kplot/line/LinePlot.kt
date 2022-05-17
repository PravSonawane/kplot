package kplot.line

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import kplot.config.LineChartConfig
import kplot.config.lineChartConfig
import kplot.data.DataSet
import kplot.data.dataSetOf

@Composable
fun LinePlot(
    dataSet: DataSet,
    modifier: Modifier = Modifier,
    config: LineChartConfig = lineChartConfig()
) {
    val maxData = remember { dataSet.values.maxOrNull() ?: 1f }

    Canvas(modifier = modifier.fillMaxSize()) {
        val maxWidth = size.width
        val maxHeight = size.height

        for (it in 0 until dataSet.values.size - 1) {
            val xStart = maxWidth * (it.toFloat() / (dataSet.values.size - 1))
            val yStart = maxHeight - (maxHeight * (dataSet.values[it] / maxData))
            val xEnd = maxWidth * ((it + 1f) / (dataSet.values.size - 1))
            val yEnd = maxHeight - (maxHeight * (dataSet.values[it + 1] / maxData))
            val start = Offset(x = xStart, y = yStart)
            val end = Offset(x = xEnd, y = yEnd)

            drawLine(
                start = start,
                end = end,
                color = config.color,
                strokeWidth = config.strokeWidth.toPx()
            )

            // add circles to smooth off line ends
            if(it == 0) {
                drawCircle(color = config.color, center = start, radius = config.strokeWidth.toPx() / 2)
            }
            drawCircle(color = config.color, center = end, radius = config.strokeWidth.toPx() / 2)

        }
    }
}

@Preview
@Composable
fun LinePlotPreview() {
    LinePlot(dataSetOf(1f, 2f, 13f, 4f))
}