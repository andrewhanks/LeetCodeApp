package com.example.andrewhanks.leetcodeapp

class Question004MedianofTwoSortedArrays {

    companion object {

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val nums1Length = nums1.size
            val nums2Length = nums2.size
            val times = (nums1Length + nums2Length) / 2
            val rest = (nums1Length + nums2Length) % 2
            var result = 0.0
            if (rest == 1) {
                var nums1Count = 0
                var nums2Count = 0
                var whichIntArray = 1
                for (count in 0 until times + 1) {
                    if (nums1Length == 0) {
                        nums2Count++
                        whichIntArray = 2
                    } else if (nums2Length == 0) {
                        nums1Count++
                        whichIntArray = 1
                    } else if (nums1Count == nums1Length) {
                        nums2Count++
                        whichIntArray = 2
                    } else if (nums2Count == nums2Length) {
                        nums1Count++
                        whichIntArray = 1
                    } else {
                        if (nums1[nums1Count] >= nums2[nums2Count]) {
                            nums2Count++
                            whichIntArray = 2
                        } else {
                            nums1Count++
                            whichIntArray = 1
                        }
                    }
                }
                if (whichIntArray == 1) {
                    result = nums1[nums1Count - 1].toDouble()
                } else {
                    result = nums2[nums2Count - 1].toDouble()
                }
            } else {
                var nums1Count = 0
                var nums2Count = 0
                var previousArray = 1
                var lastArray = 1
                for (count in 0 until times + 1) {
                    if (nums1Length == 0) {
                        nums2Count++
                        previousArray = lastArray
                        lastArray = 2
                    } else if (nums2Length == 0) {
                        nums1Count++
                        previousArray = lastArray
                        lastArray = 1
                    } else if (nums1Count == nums1Length) {
                        nums2Count++
                        previousArray = lastArray
                        lastArray = 2
                    } else if (nums2Count == nums2Length) {
                        nums1Count++
                        previousArray = lastArray
                        lastArray = 1
                    } else {
                        if (nums1[nums1Count] >= nums2[nums2Count]) {
                            nums2Count++
                            previousArray = lastArray
                            lastArray = 2
                        } else {
                            nums1Count++
                            previousArray = lastArray
                            lastArray = 1
                        }
                    }
                }
                if (lastArray == 1) {
                    result = nums1[nums1Count - 1].toDouble()
                } else {
                    result = nums2[nums2Count - 1].toDouble()
                }

                if (lastArray == 1 && previousArray == 1) {
                    result += nums1[nums1Count - 2]
                } else if (lastArray == 2 && previousArray == 2) {
                    result += nums2[nums2Count - 2]
                } else {
                    if (previousArray == 1) {
                        result += nums1[nums1Count - 1]
                    } else {
                        result += nums2[nums2Count - 1]
                    }
                }

                result = result / 2
            }

            return result
        }
    }
}