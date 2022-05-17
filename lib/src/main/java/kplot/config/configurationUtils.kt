package kplot.config


fun config(): DefaultConfiguration {
    return DefaultConfiguration()
}

fun DefaultConfiguration.barChart(): BarChartConfig {
    return BarChartConfig()
}

fun DefaultConfiguration.lineChart(): LineChartConfig {
    return LineChartConfig()
}

