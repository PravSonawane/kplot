package kplot.config

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kplot.barplot.Justification
import kplot.barplot.BarStyle

data class BarChartConfig(
    val justification: Justification = Justification.CENTER,
    val style: BarStyle = BarStyle.PACKED,
    val barWidth: Dp = 20.dp,
    val barSeparatorWidth: Dp = 2.dp,
) : ChartConfiguration