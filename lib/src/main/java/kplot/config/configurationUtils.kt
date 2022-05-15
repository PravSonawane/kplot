package kplot.config


fun config(): DefaultConfiguration {
    return DefaultConfiguration()
}

fun DefaultConfiguration.barChart(): BarChartConfig {
    return BarChartConfig()
}

