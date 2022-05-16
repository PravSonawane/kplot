package kplot.data

fun dataSetOf(vararg data: Int): DataSet {
    val array = FloatArray(data.size)
    for (i in data.indices) {
        array[i] = data[i].toFloat()
    }
    return DataSet(array)
}

fun dataSetOf(vararg data: Float): DataSet {
    return DataSet(data)
}