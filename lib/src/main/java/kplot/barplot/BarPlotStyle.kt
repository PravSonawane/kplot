package kplot.barplot

import kplot.bar.BarPlot

/**
 * Style used to layout bars in a [BarPlot]
 */
enum class BarPlotStyle {
    /** Bars are packed close to one another */
    PACKED,

    /** Bars are spread across the available width and equidistant from one another. */
    SPREAD
}