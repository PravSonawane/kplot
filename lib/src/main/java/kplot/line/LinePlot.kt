package kplot.line

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LinePlot(data: FloatArray, modifier: Modifier = Modifier) {

    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue,
            strokeWidth = 4f
        )
    }
}

@Preview
@Composable
fun LinePlotPreview() {
    LinePlot(data = floatArrayOf(1f, 4f, 2f, 3f))
}