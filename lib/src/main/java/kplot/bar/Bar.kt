package kplot.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A compose function that displays a bar.
 * @param modifier a compose [Modifier]
 */
@Composable
fun Bar(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
        .background(color = MaterialTheme.colors.primary)) {

    }
}

/**
 * Compose preview for [Bar]
 */
@Preview
@Composable
fun BarPreview() {
    Bar()
}
