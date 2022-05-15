package kplot.config


fun config(): DefaultConfiguration {
    return DefaultConfiguration()
}

fun DefaultConfiguration.bar(): BarChartConfiguration {
    return BarChartConfiguration()
}

