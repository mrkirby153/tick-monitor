package com.mrkirby153.tickmonitor.math

import java.util.*

class RollingAverage(val size: Int) {

    private val dataSet: LinkedList<Double> = LinkedList()

    fun clear() {
        this.dataSet.clear()
    }

    fun add(number: Number) {
        dataSet.add(number.toDouble())
        while (dataSet.size > size) {
            dataSet.removeFirst()
        }
    }

    fun average(): Double {
        var sum = 0.0
        var elements = 0
        dataSet.forEach { sum += it; elements++ }
        return sum / elements
    }

    fun getData() = dataSet

    override fun toString(): String {
        return dataSet.toString()
    }
}