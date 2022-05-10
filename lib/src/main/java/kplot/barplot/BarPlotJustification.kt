package kplot.barplot

import kplot.bar.BarPlot

/**
 * Justification used to layout bars in a [BarPlot]. Justification is ignored if the [BarPlot]
 * uses [BarPlotStyle.SPREAD].
 */
enum class BarPlotJustification {

    /** Bars are aligned to the start of the [BarPlot] */
    START,
    CENTER,
    END
}