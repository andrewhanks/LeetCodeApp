package com.example.andrewhanks.leetcodeapp


class Question046_Permutations {

    companion object {

        fun permute(nums: IntArray): List<List<Int>> {
            val resultArray = ArrayList<List<Int>>()
            permuteArray(nums, 0, nums.size - 1, resultArray)
            return resultArray
        }

        fun permuteArray(nums: IntArray, i: Int, j: Int, resultArray: MutableList<List<Int>>) {
            if (i == j) {
                resultArray.add(nums.toMutableList())
            } else {
                for (count in i..j) {
                    nums[i] = nums[count].also { nums[count] = nums[i] }
                    permuteArray(nums, i + 1, j, resultArray)
                    nums[count] = nums[i].also { nums[i] = nums[count] }
                }
            }
        }
    }
}