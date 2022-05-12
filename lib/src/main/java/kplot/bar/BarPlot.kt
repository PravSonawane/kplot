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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kplot.barplot.BarPlotJustification
import kplot.barplot.BarPlotStyle

/**
 * A compose function that plots [Bar]s
 */
@Suppress("MagicNumber")
@Composable
fun BarPlot(
    data: FloatArray,
    modifier: Modifier = Modifier,
    style: BarPlotStyle = BarPlotStyle.PACKED,
    justification: BarPlotJustification = BarPlotJustification.CENTER,
    separator: Dp = 2.dp
) {
    val maxData = remember { data.maxOrNull() ?: 1f }
    Layout(
        modifier = modifier,
        content = {
            repeat(data.size) {
                Bar()
            }
        }
    ) { measurables, constraints ->

        val barMinThicknessPercentage = 0.125
        val barMaxThicknessPercentage = 0.15
        val placeables = measurables.mapIndexed { i, m ->
            m.measure(
                Constraints(
                    minWidth = (constraints.minWidth * barMinThicknessPercentage).toInt(),
                    maxWidth = (constraints.maxWidth * barMaxThicknessPercentage).toInt(),
                    minHeight = (constraints.maxHeight * (data[i] / maxData)).toInt(),
                    maxHeight = (constraints.maxHeight * (data[i] / maxData)).toInt()
                )
            )
        }

        when (style) {
            BarPlotStyle.SPREAD -> layoutSpread(constraints, placeables)
            BarPlotStyle.PACKED -> layoutPacked(constraints, placeables, justification, separator)
        }

    }
}

/**
 * Lays out the bars in a 'spread' manner occupying all the available width. Bars are placed equidistant from one another.
 * @param constraints constraints for layout
 * @param placeables items to be placed
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
 * @param constraints constraints for layout
 * @param placeables items to be placed
 * @param justification specifies where the bars should be placed. See [BarPlotJustification]
 */
private fun MeasureScope.layoutPacked(
    constraints: Constraints,
    placeables: List<Placeable>,
    justification: BarPlotJustification,
    separator: Dp = 2.dp
): MeasureResult {
    return when (justification) {
        BarPlotJustification.START -> layoutPackedStart(constraints, placeables, separator)
        BarPlotJustification.CENTER -> layoutPackedCenter(constraints, placeables, separator)
        BarPlotJustification.END -> layoutPackedEnd(constraints, placeables, separator)
    }
}

/**
 * Bars are placed from the start of the available width.
 * @param constraints constraints for layout
 * @param placeables items to be placed
 */
private fun MeasureScope.layoutPackedStart(
    constraints: Constraints,
    placeables: List<Placeable>,
    separator: Dp = 2.dp
): MeasureResult {
    return layout(constraints.maxWidth, constraints.maxHeight) {
        var x = 0
        placeables.forEach { p ->
            val y = constraints.maxHeight - p.height

            p.place(x, y)

            // move ahead by width of an item and then add a separator
            x += p.width + separator.toPx().toInt()
        }
    }
}

/**
 * Bars are placed in the center of the available width.
 * @param constraints constraints for layout
 * @param placeables items to be placed
 */
private fun MeasureScope.layoutPackedCenter(
    constraints: Constraints,
    placeables: List<Placeable>,
    separator: Dp = 2.dp
): MeasureResult {
    return layout(constraints.maxWidth, constraints.maxHeight) {
        var x = 0
        placeables.forEachIndexed { i, p ->
            val y = constraints.maxHeight - p.height

            if(i == 0) {
                // find x for first item from center of width
                x += constraints.maxWidth / 2
                x -= (placeables.size * (p.width + separator.toPx().toInt())) / 2
            }

            p.place(x, y)

            // move ahead by width of an item and then add a separator
            x += p.width + separator.toPx().toInt()
        }
    }
}

/**
 * Bars are placed at the end of the available width.
 * @param constraints constraints for layout
 * @param placeables items to be placed
 */
private fun MeasureScope.layoutPackedEnd(
    constraints: Constraints,
    placeables: List<Placeable>,
    separator: Dp = 2.dp
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
            x -= separator.toPx().toInt()
        }
    }
}

@Preview
@Composable
fun BarPlotPreview() {
    BarPlot(
        floatArrayOf(1f, 4f, 2f, 5f),
        style = BarPlotStyle.PACKED,
        justification = BarPlotJustification.CENTER
    )
}
