package kplot.bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import kplot.barplot.BarStyle
import kplot.barplot.Justification
import kplot.config.BarChartConfig
import kplot.config.barChartConfig
import kplot.config.justify
import kplot.config.style
import kplot.data.DataSet
import kplot.data.dataSetOf

/**
 * A compose function that plots [Bar]s
 */
@Suppress("MagicNumber")
@Composable
fun BarPlot(
    dataSet: DataSet,
    modifier: Modifier = Modifier,
    config: BarChartConfig = barChartConfig()
) {
    val maxData = remember { dataSet.values.maxOrNull() ?: 1f }
    val minData = remember { dataSet.values.maxOrNull() ?: 0f }
    require(minData >= 0) { "Using BarPlot for non-positive values is not supported"}

    Layout(
        modifier = modifier,
        content = {
            repeat(dataSet.values.size) {
                Bar()
            }
        }
    ) { measurables, constraints ->

        val placeables = measurables.mapIndexed { i, m ->
            m.measure(
                Constraints(
                    minWidth = config.barWidth.toPx().toInt(),
                    maxWidth = config.barWidth.toPx().toInt(),
                    minHeight = (constraints.maxHeight * (dataSet.values[i] / maxData)).toInt(),
                    maxHeight = (constraints.maxHeight * (dataSet.values[i] / maxData)).toInt()
                )
            )
        }

        when (config.style) {
            BarStyle.SPREAD -> layoutSpread(constraints, placeables)
            BarStyle.PACKED -> layoutPacked(constraints, placeables, config)
        }

    }
}

/**
 * Lays out the bars in a 'spread' manner occupying all the available width. Bars are placed equidistant from one another.
 */
private fun MeasureScope.layoutSpread(
    constraints: Constraints,
    placeables: List<Placeable>
) = layout(constraints.maxWidth, constraints.maxHeight) {
    val barCount = placeables.size
    val divider = if (barCount == 1) 1 else barCount - 1
    var x = 0
    placeables.forEachIndexed { i, p ->
        val y = constraints.maxHeight - p.height

        val itemWidthOffset = (p.width * (i.toFloat() / divider)).toInt()

        // the x & y coordinates are the top left corner of the item
        // item width is subtracted from x coordinate to left shift and fit the items
        p.place(x - itemWidthOffset, y)

        x += constraints.maxWidth / divider
    }
}

/**
 * Lays out the bars in a 'packed' manner. Bars are placed close to one another.
 */
private fun MeasureScope.layoutPacked(
    constraints: Constraints,
    placeables: List<Placeable>,
    config: BarChartConfig
): MeasureResult {
    return when (config.justification) {
        Justification.START -> layoutPackedStart(constraints, placeables, config)
        Justification.CENTER -> layoutPackedCenter(constraints, placeables, config)
        Justification.END -> layoutPackedEnd(constraints, placeables, config)
    }
}

/**
 * Bars are placed from the start of the available width.
 */
private fun MeasureScope.layoutPackedStart(
    constraints: Constraints,
    placeables: List<Placeable>,
    config: BarChartConfig
): MeasureResult {
    return layout(constraints.maxWidth, constraints.maxHeight) {
        var x = 0
        placeables.forEach { p ->
            val y = constraints.maxHeight - p.height

            p.place(x, y)

            // move ahead by width of an item and then add a separator
            x += p.width + config.barSeparatorWidth.toPx().toInt()
        }
    }
}

/**
 * Bars are placed in the center of the available width.
 */
private fun MeasureScope.layoutPackedCenter(
    constraints: Constraints,
    placeables: List<Placeable>,
    config: BarChartConfig
): MeasureResult {
    return layout(constraints.maxWidth, constraints.maxHeight) {
        var x = 0
        placeables.forEachIndexed { i, p ->
            val y = constraints.maxHeight - p.height

            if(i == 0) {
                // find x for first item from center of width
                x += constraints.maxWidth / 2
                x -= (placeables.size * (p.width + config.barSeparatorWidth.toPx().toInt())) / 2
            }

            p.place(x, y)

            // move ahead by width of an item and then add a separator
            x += p.width + config.barSeparatorWidth.toPx().toInt()
        }
    }
}

/**
 * Bars are placed at the end of the available width.
 */
private fun MeasureScope.layoutPackedEnd(
    constraints: Constraints,
    placeables: List<Placeable>,
    config: BarChartConfig
): MeasureResult {
    return layout(constraints.maxWidth, constraints.maxHeight) {

        // start from the end
        var x = constraints.maxWidth

        // place items in reverse order
        placeables.reversed().forEach { p ->

            val y = constraints.maxHeight - p.height

            // make place for width of an item, place it and then add a separator
            x -= p.width
            p.place(x, y)
            x -= config.barSeparatorWidth.toPx().toInt()
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot(
        dataSetOf(1, 4, 2, 5),
        config = barChartConfig().justify(Justification.CENTER).style(BarStyle.PACKED)
    )
}
