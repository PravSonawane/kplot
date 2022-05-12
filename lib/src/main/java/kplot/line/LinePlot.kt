package kplot.line

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LinePlot(data: FloatArray, modifier: Modifier = Modifier) {
    val maxData = remember { data.maxOrNull() ?: 1f }
    val primaryColor = MaterialTheme.colors.primary

    Canvas(modifier = modifier.fillMaxSize()) {
        val maxWidth = size.width
        val maxHeight = size.height

        for (it in 0 until data.size - 1) {
            val xStart = maxWidth * (it.toFloat() / (data.size - 1))
            val yStart = maxHeight - (maxHeight * (data[it] / maxData))
            val xEnd = maxWidth * ((it + 1f) / (data.size - 1))
            val yEnd = maxHeight - (maxHeight * (data[it + 1] / maxData))
            drawLine(
                start = Offset(x = xStart, y = yStart),
                end = Offset(x = xEnd, y = yEnd),
                color = primaryColor,
                strokeWidth = 4f
            )
        }
    }
}

@Preview
@Composable
fun LinePlotPreview() {
    LinePlot(data = floatArrayOf(1f, 2f, 13f, 4f))
}