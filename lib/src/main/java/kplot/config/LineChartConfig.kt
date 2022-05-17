package kplot.config

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class LineChartConfig(
    val strokeWidth: Dp = 2.dp,
    val color: Color = Color.Unspecified
)