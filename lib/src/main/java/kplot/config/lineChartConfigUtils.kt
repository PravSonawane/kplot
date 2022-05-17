package kplot.config

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun lineChartConfig(): LineChartConfig {
    return LineChartConfig()
}

fun LineChartConfig.strokeWidth(width: Dp): LineChartConfig {
    return copy(strokeWidth = width)
}

fun LineChartConfig.color(color: Color): LineChartConfig {
    return copy(color = color)
}