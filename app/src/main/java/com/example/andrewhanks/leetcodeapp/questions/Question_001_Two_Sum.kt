package com.example.andrewhanks.leetcodeapp.questions

class Question_001_Two_Sum {

    companion object {

        fun twoSum(nums: IntArray, target: Int): IntArray {
            nums.forEachIndexed { firstNumber, i ->
                for (secondNumber in (firstNumber + 1)..(nums.size - 1)) {
                    if (target == nums[firstNumber] + nums[secondNumber]) {
                        return intArrayOf(firstNumber, secondNumber)
                    }
                }
            }
            return intArrayOf(0)
        }
    }
}