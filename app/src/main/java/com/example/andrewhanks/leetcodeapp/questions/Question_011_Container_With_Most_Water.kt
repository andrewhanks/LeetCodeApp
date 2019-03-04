package com.example.andrewhanks.leetcodeapp.questions

import android.util.Log

class Question_011_Container_With_Most_Water {

    companion object {

        val TAG = Question_011_Container_With_Most_Water.javaClass.simpleName

        // brute force
        fun maxArea1(height: IntArray): Int {
            var waterSum = 0
            for (index1 in 0..height.size - 1) {
                for (index2 in index1 + 1..height.size - 1) {
                    val minHeight = Math.min(height[index1], height[index2])
                    val currentWater = minHeight * (index2 - index1)
                    Log.d(TAG, "${index1}, ${index2}, ${currentWater}")
                    if (currentWater > waterSum) {
                        waterSum = currentWater
                    }
                }
            }
            return waterSum
        }

        fun maxArea2(height: IntArray): Int {
            val maxHeight = height.max() ?: 0
            var maxWaterSum = 0
            if (0 == maxHeight) {
                return 0
            }
            for (waterHeight in 1..maxHeight) {
                var start = 0
                var end = 0
                loopStart@ for (startPosition in 0..height.size - 1) {
                    if (height[startPosition] >= waterHeight) {
                        start = startPosition
                        break@loopStart
                    }
                }
                loopEnd@ for (endPosition in height.size - 1 downTo start + 1) {
                    if (height[endPosition] >= waterHeight) {
                        end = endPosition
                        break@loopEnd
                    }
                }
                if (0 == end) {
                    start = 0
                    end = 0
                }
                val currentWater = waterHeight * (end - start)
                Log.d(TAG, "${height}, ${start}, ${end}, ${currentWater}")
                if (currentWater > maxWaterSum) {
                    maxWaterSum = currentWater
                }
            }
            return maxWaterSum
        }
    }
}