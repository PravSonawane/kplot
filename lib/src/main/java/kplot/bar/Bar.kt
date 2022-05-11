package kplot.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * A compose function that displays a bar.
 * @param modifier a compose [Modifier]
 */
@Composable
fun Bar(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
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
