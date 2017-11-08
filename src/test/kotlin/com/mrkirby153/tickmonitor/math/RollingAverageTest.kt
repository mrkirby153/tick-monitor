package com.mrkirby153.tickmonitor.math

import org.junit.Assert
import org.junit.Test

class RollingAverageTest {
    @Test
    fun clear() {
        val average = RollingAverage(2)
        average.add(1)
        average.add(2)

        Assert.assertTrue(average.getData().isNotEmpty())
        average.clear()
        Assert.assertFalse(average.getData().isNotEmpty())
    }

    @Test
    fun add() {
        val average = RollingAverage(2)
        average.add(1)
        average.add(2)

        Assert.assertTrue(average.getData()[0] == 1.0)
        Assert.assertTrue(average.getData()[1] == 2.0)
    }

    @Test
    fun add2(){
        val average = RollingAverage(2)
        average.add(1)
        average.add(2)

        average.add(3)
        Assert.assertTrue(average.getData()[0] == 2.0)
        Assert.assertTrue(average.getData()[1] == 3.0)
    }

    @Test
    fun average() {
        val average = RollingAverage(2)

        average.add(1)
        average.add(2)

        Assert.assertEquals(average.average(), 1.5, 0.1)
    }

    @Test
    fun average2(){
        val average = RollingAverage(2)
        average.add(1)
        average.add(2)

        average.add(3)
        Assert.assertEquals(average.average(), 2.5, 0.1)
    }

}