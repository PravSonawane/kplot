package kplot.config

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kplot.barplot.Justification
import kplot.barplot.BarStyle

data class BarChartConfiguration(
    internal val justification: Justification = Justification.CENTER,
    internal val style: BarStyle = BarStyle.PACKED,
    internal var barWidth: Dp = 20.dp,
    internal var barSeparatorWidth: Dp = 2.dp,
) : ChartConfiguration