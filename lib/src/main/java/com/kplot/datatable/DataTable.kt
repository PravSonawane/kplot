package com.kplot.datatable

class DataTable {

    private val data: MutableList<MutableList<Float>> = ArrayList()
    private val columns: MutableList<String> = ArrayList()

    private var columnNameIndex = 0

    fun addColumn(name: String? = null, data: List<Float> = emptyList()) {
        if(name == null) {
            columns.add("Column_" + (columnNameIndex++))
        }
        this.data.add(data as MutableList<Float>)
    }
}