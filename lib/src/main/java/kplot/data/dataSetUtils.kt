package kplot.data

fun dataSetOf(vararg data: Int): FloatArray {
    val array = FloatArray(data.size)
    for (i in data.indices) {
        array[i] = data[i].toFloat()
    }
    return array
}

fun dataSetOf(vararg data: Float): FloatArray {
    return data
}