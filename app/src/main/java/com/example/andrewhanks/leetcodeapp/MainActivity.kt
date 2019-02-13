package com.example.andrewhanks.leetcodeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    // layout for question 6
    private lateinit var question6Input1: EditText
    private lateinit var question6Input2: EditText
    private lateinit var question6Button: Button
    private lateinit var question6Result: TextView

    // layout for question 8
    private lateinit var question8Input: EditText
    private lateinit var question8Button: Button
    private lateinit var question8Result: TextView

    // layout for question 9
    private lateinit var question9Input: EditText
    private lateinit var question9Button: Button
    private lateinit var question9Result: TextView

    // layout for question 11
    private lateinit var question11Input: EditText
    private lateinit var question11Button: Button
    private lateinit var question11Result: TextView

    // layout for question 12
    private lateinit var question12Input: EditText
    private lateinit var question12Button: Button
    private lateinit var question12Result: TextView

    // layout for question 15
    private lateinit var question15Input: EditText
    private lateinit var question15Button: Button
    private lateinit var question15Result: TextView

    // layout for question 16
    private lateinit var question16Input1: EditText
    private lateinit var question16Input2: EditText
    private lateinit var question16Button: Button
    private lateinit var question16Result: TextView

    // layout for question 17
    private lateinit var question17Input: EditText
    private lateinit var question17Button: Button
    private lateinit var question17Result: TextView

    // layout for question 43
    private lateinit var question43Input1: EditText
    private lateinit var question43Input2: EditText
    private lateinit var question43Button: Button
    private lateinit var question43Result: TextView

    // layout for question 46
    private lateinit var question46Input: EditText
    private lateinit var question46Button: Button
    private lateinit var question46Result: TextView

    // layout for question 442
    private lateinit var question442Input: EditText
    private lateinit var question442Button: Button
    private lateinit var question442Result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupQuestion1()
        setupQuestion2()
        setupQuestion3()
        setupQuestion4()
        setupQuestion5()
        setupQuestion6()
        setupQuestion9()
        setupQuestion8()
        setupQuestion11()
        setupQuestion12()
        setupQuestion15()
        setupQuestion16()
        setupQuestion17()
        setupQuestion43()
        setupQuestion46()
        setupQuestion442()
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
            val resultArray = Question001_TwoSum.twoSum(numberArray, numberSum)
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
            val resultListNode = Question002_AddTwoNumbers.addTwoNumbers(listNode1, listNode2)
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
            val result = Question003_LongestSubstringWithoutRepeatingCharacters
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
            val result = Question004_MedianofTwoSortedArrays
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
            val result = Question005_LongestPalindromicSubstring.longestPalindromeWebSolution(inputString)
            question5Result.text = result
        }
        question5Result = findViewById(R.id.question_5_result)
    }

    private fun setupQuestion6() {
        question6Input1 = findViewById(R.id.question_6_input_1)
        question6Input2 = findViewById(R.id.question_6_input_2)
        question6Button = findViewById(R.id.question_6)
        question6Button.setOnClickListener {
            val inputString = if (question6Input1.text.isBlank()) {
                "PAYPALISHIRING"
            } else {
                question6Input1.text.toString()
            }
            val inputRows = if (question6Input2.text.isBlank()) {
                3
            } else {
                question6Input2.text.toString().toInt()
            }
            val result = Question006_ZigZagConversion.convert(inputString, inputRows)
            question6Result.text = result
        }
        question6Result = findViewById(R.id.question_6_result)
    }

    private fun setupQuestion8() {
        question8Input = findViewById(R.id.question_8_input)
        question8Button = findViewById(R.id.question_8)
        question8Button.setOnClickListener {
            val inputString = if (question8Input.text.isEmpty()) {
                "42"
            } else {
                question8Input.text.toString()
            }
            val result = Question008_StringtoInteger.myAtoi(inputString)
            question8Result.text = result.toString()
        }
        question8Result = findViewById(R.id.question_8_result)
    }

    private fun setupQuestion9() {
        question9Input = findViewById(R.id.question_9_input)
        question9Button = findViewById(R.id.question_9)
        question9Button.setOnClickListener {
            val inputInt = if (question9Input.text.isBlank()) {
                121
            } else {
                question9Input.text.toString().toInt()
            }
            val result = Question009_PalindromeNumber.isPalindrome(inputInt)
            question9Result.text = result.toString()
        }
        question9Result = findViewById(R.id.question_9_result)
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
            val result = Question011_ContainerWithMostWater.maxArea2(numberArray)
            question11Result.text = result.toString()
        }
        question11Result = findViewById(R.id.question_11_result)
    }

    private fun setupQuestion12() {
        question12Input = findViewById(R.id.question_12_input)
        question12Button = findViewById(R.id.question_12)
        question12Button.setOnClickListener {
            val input = if (question12Input.text.isBlank()) {
                3
            } else {
                question12Input.text.toString().toInt()
            }
            val result = Question012_IntegertoRoman.intToRoman(input)
            question12Result.text = result
        }
        question12Result = findViewById(R.id.question_12_result)
    }

    private fun setupQuestion15() {
        question15Input = findViewById(R.id.question_15_input)
        question15Button = findViewById(R.id.question_15)
        question15Button.setOnClickListener {
            val intArray = if (question15Input.text.isBlank()) {
                "-1,0,1,2,-1,-4"
                        .split(',')
                        .map { num -> num.toInt() }
                        .toIntArray()
            } else {
                question15Input.text.toString()
                        .split(',')
                        .map { num -> num.toInt() }
                        .toIntArray()
            }
            val resultList = Question015_3Sum.threeSumWebSolution(intArray)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            question15Result.text = result
        }
        question15Result = findViewById(R.id.question_15_result)
    }

    private fun setupQuestion16() {
        question16Input1 = findViewById(R.id.question_16_input_1)
        question16Input2 = findViewById(R.id.question_16_input_2)
        question16Button = findViewById(R.id.question_16)
        question16Button.setOnClickListener {
            val inputNums = if (question16Input1.text.isBlank()) {
                "1,1,-1,-1,3"
                        .split(",")
                        .map { it.toInt() }
                        .toIntArray()
            } else {
                question16Input1.text.toString()
                        .split(",")
                        .map { it.toInt() }
                        .toIntArray()
            }
            val inputTarget = if (question16Input2.text.isBlank()) {
                -1
            } else {
                question16Input2.text.toString().toInt()
            }
            val result = Question016_3SumClosest.threeSumClosest(inputNums, inputTarget)
            question16Result.text = result.toString()
        }
        question16Result = findViewById(R.id.question_16_result)
    }

    private fun setupQuestion17() {
        question17Input = findViewById(R.id.question_17_input)
        question17Button = findViewById(R.id.question_17)
        question17Button.setOnClickListener {
            val number = if (question17Input.text.isBlank()) {
                (23).toString()
            } else {
                question12Input.text.toString()
            }
            val result = Question017_LetterCombinationsofaPhoneNumber.letterCombinations(number)
            question17Result.text = result.toString()
        }
        question17Result = findViewById(R.id.question_17_result)
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
            val result = Question043_MultiplyStrings.multiply(stringNumber1, stringNumber2)
            question43Result.text = result
        }
        question43Result = findViewById(R.id.question_43_result)
    }

    private fun setupQuestion46() {
        question46Input = findViewById(R.id.question_46_input)
        question46Button = findViewById(R.id.question_46)
        question46Button.setOnClickListener {
            val intArray = if (question46Input.text.isBlank()) {
                "1,2,3"
                        .split(',')
                        .map { num -> num.toInt() }
                        .toIntArray()
            } else {
                question46Input.text.toString()
                        .split(',')
                        .map { num -> num.toInt() }
                        .toIntArray()
            }
            val resultList = Question046_Permutations.permute(intArray)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            question46Result.text = result
        }
        question46Result = findViewById(R.id.question_46_result)
    }

    private fun setupQuestion442() {
        question442Input = findViewById(R.id.question_442_input)
        question442Button = findViewById(R.id.question_442)
        question442Button.setOnClickListener {
            val inputIntArray = if (question442Input.text.isBlank()) {
                "4,3,2,7,8,2,3,1"
                        .split(",")
                        .map { num -> num.toInt() }
                        .toIntArray()
            } else {
                question442Input.text.toString()
                        .split(",")
                        .map { it.toInt() }
                        .toIntArray()
            }
            val resultList = Question442_FindAllDuplicatesinanArray.findDuplicatesWebSolution(inputIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            question442Result.text = result
        }
        question442Result = findViewById(R.id.question_442_result)
    }
}
