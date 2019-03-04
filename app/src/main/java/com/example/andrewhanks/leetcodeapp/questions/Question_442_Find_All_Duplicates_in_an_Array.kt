package com.example.andrewhanks.leetcodeapp.questions

class Question_442_Find_All_Duplicates_in_an_Array {

    companion object {

        // Mapping (values - 1) in this array to indexes
        fun findDuplicatesWebSolution(nums: IntArray): List<Int> {
            val res = ArrayList<Int>()
            for (i in 0..nums.size - 1) {
                val index = Math.abs(nums[i]) - 1
                if (nums[index] < 0) {
                    res.add(Math.abs(index + 1))
                }
                nums[index] = -nums[index]
            }
            return res
        }
    }
}