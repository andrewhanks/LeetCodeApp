package com.example.andrewhanks.leetcodeapp

class Question009PalindromeNumber {

    companion object {

        fun isPalindrome(x: Int): Boolean {
            val countFromFront = x.toString()
            val countFromBack = x.toString().reversed()
            return countFromFront == countFromBack
        }
    }
}