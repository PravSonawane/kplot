package kplot.config

import androidx.compose.ui.unit.Dp
import kplot.barplot.Justification
import kplot.barplot.BarStyle

fun barConfig(): BarChartConfiguration {
    return BarChartConfiguration()
}

fun BarChartConfiguration.justify(justification: Justification): BarChartConfiguration {
    return copy(justification = justification)
}

fun BarChartConfiguration.style(style: BarStyle): BarChartConfiguration {
    return copy(style = style)
}

fun BarChartConfiguration.barWidth(width: Dp): BarChartConfiguration {
    return copy(barWidth = width)
}

fun BarChartConfiguration.barSeparatorWidth(width: Dp): BarChartConfiguration {
    return copy(barSeparatorWidth = width)
}