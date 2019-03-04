package com.example.andrewhanks.leetcodeapp.questions

import com.example.andrewhanks.leetcodeapp.models.ListNode

class Question_019_Remove_Nth_Node_From_End_of_List {

    companion object {

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            if (null == head) {
                return null
            }
            var totalCount = 1
            var currentNode = head
            while (null != currentNode!!.next) {
                totalCount++
                currentNode = currentNode.next
            }
            System.out.println("totalCount = ${totalCount}")

            var finalRemoveItemCount = totalCount - n + 1
            currentNode = head

            if (1 == finalRemoveItemCount) {
                return head.next
            } else if (1 == totalCount) {
                return null
            } else if (2 == totalCount && 1 == n) {
                head.next = null
                return head
            }

            var nextNode = currentNode.next
            while (finalRemoveItemCount > 2) {
                currentNode = currentNode!!.next
                nextNode = currentNode!!.next
                finalRemoveItemCount--
            }

            currentNode!!.next = nextNode!!.next

            return head
        }
    }
}