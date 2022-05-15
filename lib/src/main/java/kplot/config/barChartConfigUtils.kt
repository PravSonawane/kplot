package kplot.config

import androidx.compose.ui.unit.Dp
import kplot.barplot.Justification
import kplot.barplot.BarStyle

fun barChartConfig(): BarChartConfig {
    return BarChartConfig()
}

fun BarChartConfig.justify(justification: Justification): BarChartConfig {
    return copy(justification = justification)
}

fun BarChartConfig.style(style: BarStyle): BarChartConfig {
    return copy(style = style)
}

fun BarChartConfig.barWidth(width: Dp): BarChartConfig {
    return copy(barWidth = width)
}

fun BarChartConfig.barSeparatorWidth(width: Dp): BarChartConfig {
    return copy(barSeparatorWidth = width)
}