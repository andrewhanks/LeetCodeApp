package com.example.andrewhanks.leetcodeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // layout for question 1
    private lateinit var question1Input1: EditText
    private lateinit var question1Input2: EditText
    private lateinit var question1Button: Button
    private lateinit var question1Result: TextView

    // layout for question 2
    private lateinit var question2Input1: EditText
    private lateinit var question2Input2: EditText
    private lateinit var question2Button: Button
    private lateinit var question2Result: TextView

    // layout for question 3
    private lateinit var question3Input: EditText
    private lateinit var question3Button: Button
    private lateinit var question3Result: TextView

    // layout for question 4
    private lateinit var question4Input1: EditText
    private lateinit var question4Input2: EditText
    private lateinit var question4Button: Button
    private lateinit var question4Result: TextView

    // layout for question 5
    private lateinit var question5Input: EditText
    private lateinit var question5Button: Button
    private lateinit var question5Result: TextView

    // layout for question 11
    private lateinit var question11Input: EditText
    private lateinit var question11Button: Button
    private lateinit var question11Result: TextView

    // layout for question 43
    private lateinit var question43Input1: EditText
    private lateinit var question43Input2: EditText
    private lateinit var question43Button: Button
    private lateinit var question43Result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupQuestion1()
        setupQuestion2()
        setupQuestion3()
        setupQuestion4()
        setupQuestion5()
        setupQuestion11()
        setupQuestion43()
    }

    private fun setupQuestion1() {
        question1Input1 = findViewById(R.id.question_1_input_1)
        question1Input2 = findViewById(R.id.question_1_input_2)
        question1Button = findViewById(R.id.question_1)
        question1Button.setOnClickListener {
            var numberSum = 0
            var numberArray: IntArray
            if (question1Input1.text.isBlank() || question1Input2.text.isBlank()) {
                numberArray = intArrayOf(2, 7, 11, 15)
                numberSum = 9
            } else {
                val stringArray = question1Input1.text.toString()
                        .replace(" ", "").split(",")
                numberArray = IntArray(stringArray.size)
                stringArray.forEachIndexed { index, s ->
                    numberArray[index] = s.toInt()
                }
                numberSum = question1Input2.text.toString().toInt()
            }
            val resultArray = Question001TwoSum.twoSum(numberArray, numberSum)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            question1Result.text = result
        }
        question1Result = findViewById(R.id.question_1_result)
    }

    private fun setupQuestion2() {
        question2Input1 = findViewById(R.id.question_2_input_1)
        question2Input2 = findViewById(R.id.question_2_input_2)
        question2Button = findViewById(R.id.question_2)
        question2Button.setOnClickListener {
            var listNode1 = ListNode()
            var listNode2 = ListNode()
            if (question2Input1.text.isBlank() || question2Input2.text.isBlank()) {

                listNode1.`val` = 2
                listNode1.next = ListNode(4)
                listNode1.next!!.next = ListNode(3)

                listNode2.`val` = 5
                listNode2.next = ListNode(6)
                listNode2.next!!.next = ListNode(4)

            } else {
                val stringArray1 = question2Input1.text.toString()
                        .replace(" ", "").split(",")
                val stringArray2 = question2Input2.text.toString()
                        .replace(" ", "").split(",")

                listNode1 = ListNode(stringArray1[0].toInt())
                var tempListNode1 = listNode1
                for (count in 1..stringArray1.size - 1) {
                    tempListNode1 = tempListNode1.next!!
                    tempListNode1 = ListNode(stringArray1[count].toInt())
                }
                listNode2 = ListNode(stringArray2[0].toInt())
                var tempListNode2 = listNode2
                for (count in 1..stringArray1.size - 1) {
                    tempListNode2 = tempListNode2.next!!
                    tempListNode2 = ListNode(stringArray1[count].toInt())
                }
            }
            val resultListNode = Question002AddTwoNumbers.addTwoNumbers(listNode1, listNode2)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            question2Result.text = result
        }
        question2Result = findViewById(R.id.question_2_result)
    }

    private fun setupQuestion3() {
        question3Input = findViewById(R.id.question_3_input)
        question3Button = findViewById(R.id.question_3)
        question3Button.setOnClickListener {
            val inputString = if (question3Input.text.isBlank()) {
                "abcabcbb"
            } else {
                question3Input.text.toString()
            }
            val result = Question003LongestSubstringWithoutRepeatingCharacters
                    .lengthOfLongestSubstring(inputString)
            question3Result.text = result.toString()
        }
        question3Result = findViewById(R.id.question_3_result)
    }

    private fun setupQuestion4() {
        question4Input1 = findViewById(R.id.question_4_input_1)
        question4Input2 = findViewById(R.id.question_4_input_2)
        question4Button = findViewById(R.id.question_4)
        question4Button.setOnClickListener {
            var numberArray1: IntArray
            val numberArray2: IntArray
            if (question4Input1.text.isBlank() || question4Input2.text.isBlank()) {
                numberArray1 = intArrayOf(1, 3)
                numberArray2 = intArrayOf(2)
            } else {
                val stringArray1 = question4Input1.text.toString()
                        .replace(" ", "").split(",")
                numberArray1 = IntArray(stringArray1.size)
                stringArray1.forEachIndexed { index, s ->
                    numberArray1[index] = s.toInt()
                }
                val stringArray2 = question4Input2.text.toString()
                        .replace(" ", "").split(",")
                numberArray2 = IntArray(stringArray2.size)
                stringArray2.forEachIndexed { index, s ->
                    numberArray2[index] = s.toInt()
                }
            }
            val result = Question004MedianofTwoSortedArrays
                    .findMedianSortedArrays(numberArray1, numberArray2)
            question4Result.text = result.toString()
        }
        question4Result = findViewById(R.id.question_4_result)
    }

    private fun setupQuestion5() {
        question5Input = findViewById(R.id.question_5_input)
        question5Button = findViewById(R.id.question_5)
        question5Button.setOnClickListener {
            val inputString = if (question5Input.text.isBlank()) {
                "babad"
            } else {
                question5Input.text.toString()
            }
            val result = Question005LongestPalindromicSubstring.longestPalindrome(inputString)
            question5Result.text = result
        }
        question5Result = findViewById(R.id.question_5_result)
    }

    private fun setupQuestion11() {
        question11Input = findViewById(R.id.question_11_input)
        question11Button = findViewById(R.id.question_11)
        question11Button.setOnClickListener {
            val numberArray: IntArray
            if (question11Input.text.isBlank()) {
                numberArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
            } else {
                val stringArray = question11Input.text.toString()
                        .replace(" ", "").split(",")
                numberArray = IntArray(stringArray.size)
                stringArray.forEachIndexed { index, s ->
                    numberArray[index] = s.toInt()
                }
            }
            val result = Question011ContainerWithMostWater.maxArea2(numberArray)
            question11Result.text = result.toString()
        }
        question11Result = findViewById(R.id.question_11_result)
    }

    private fun setupQuestion43() {
        question43Input1 = findViewById(R.id.question_43_input_1)
        question43Input2 = findViewById(R.id.question_43_input_2)
        question43Button = findViewById(R.id.question_43)
        question43Button.setOnClickListener {
            val stringNumber1: String
            val stringNumber2: String
            if (question43Input1.text.isBlank() || question43Input2.text.isBlank()) {
                stringNumber1 = "123"
                stringNumber2 = "456"
            } else {
                stringNumber1 = question43Input1.text.toString()
                stringNumber2 = question43Input2.text.toString()
            }
            val result = Question043MultiplyStrings.multiply(stringNumber1, stringNumber2)
            question43Result.text = result
        }
        question43Result = findViewById(R.id.question_43_result)
    }
}
