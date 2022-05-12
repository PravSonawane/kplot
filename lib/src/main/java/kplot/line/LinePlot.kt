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

        var xStart = 0f
        var yStart = maxHeight
        var xEnd = 0f
        var yEnd = 0f
        repeat(data.size) {
            xEnd = maxWidth * ((it+1f)/data.size)
            yEnd = maxHeight - (maxHeight * (data[it]/maxData))
            drawLine(
                start = Offset(x = xStart, y = yStart),
                end = Offset(x = xEnd, y = yEnd),
                color = primaryColor,
                strokeWidth = 4f
            )
            xStart = xEnd
            yStart = yEnd
        }
    }
}

@Preview
@Composable
fun LinePlotPreview() {
    LinePlot(data = floatArrayOf(0.2f, 0.5f, 1f, 3f))
}