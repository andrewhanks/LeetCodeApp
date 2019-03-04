package com.example.andrewhanks.leetcodeapp.questions

class Question_009_Palindrome_Number {

    companion object {

        fun isPalindrome(x: Int): Boolean {
            val countFromFront = x.toString()
            val countFromBack = x.toString().reversed()
            return countFromFront == countFromBack
        }
    }
}