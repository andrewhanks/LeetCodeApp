package com.example.andrewhanks.leetcodeapp.questions

class Question_022_Generate_Parentheses {

    companion object {

        val resultString = ArrayList<String>()

        fun generateParenthesis(n: Int): List<String> {

            for (count in 0..2) {
                printParenthesis("()", n - 1, count)
            }

            System.out.println("resultString size = ${resultString.size}")

            return resultString
        }

        private fun printParenthesis(completedParenthesis: String, n: Int, insertPosition: Int) {
            if (0 == n) {
                if (!resultString.contains(completedParenthesis)) {
                    resultString.add(completedParenthesis)
                }
                return
            }
            val tempParenthesis = completedParenthesis.substring(0, insertPosition) + "()" +
                    completedParenthesis.substring(insertPosition, completedParenthesis.length)
            for (count in 0..tempParenthesis.length) {
                printParenthesis(tempParenthesis, n - 1, count)
            }
        }

        fun generateParenthesisWebSolution(n: Int): List<String> {
            val list = ArrayList<String>()
            backtrack(list, "", 0, 0, n)
            System.out.println("list size = ${list.size}")
            return list
        }

        fun backtrack(list: MutableList<String>, str: String, open: Int, close: Int, max: Int) {
            if (str.length == max * 2) {
                list.add(str)
                return
            }

            if (open < max) {
                backtrack(list, "$str(", open + 1, close, max)
            }
            if (close < open) {
                backtrack(list, "$str)", open, close + 1, max)
            }
        }
    }
}