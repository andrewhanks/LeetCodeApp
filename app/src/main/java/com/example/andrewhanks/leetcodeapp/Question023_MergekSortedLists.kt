package com.example.andrewhanks.leetcodeapp

class Question023_MergekSortedLists {

    companion object {

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) {
                return null
            } else {
                var listNode = lists[0]
                for (i in 1..lists.size - 1) {
                    listNode = insertSecondListToFirstList(listNode, lists[i])
                }
                return listNode
            }
        }

        private fun insertSecondListToFirstList(firstListNode: ListNode?, secondListNode: ListNode?): ListNode? {
            if (null == firstListNode) {
                return secondListNode
            }
            if (null == secondListNode) {
                return firstListNode
            }
            var resultListNode: ListNode? = null
            var previousNode: ListNode? = null
            var currentFirstElement = firstListNode
            var currentSecondElement = secondListNode

            run addLoop@{
                do {
                    if (null == currentFirstElement) {
                        previousNode!!.next = currentSecondElement
                        return@addLoop
                    }
                    if (currentSecondElement!!.`val` < currentFirstElement!!.`val`) {
                        val insertNode = ListNode(currentSecondElement!!.`val`)
                        if (null == previousNode) {
                            insertNode.next = firstListNode
                            previousNode = insertNode
                            resultListNode = insertNode
                        } else {
                            previousNode!!.next = insertNode
                            insertNode.next = currentFirstElement
                            previousNode = insertNode
                        }
                        currentSecondElement = currentSecondElement!!.next
                    } else {
                        previousNode = currentFirstElement
                        currentFirstElement = currentFirstElement!!.next

                    }
                } while (null != currentSecondElement)
            }

            if (null == resultListNode) {
                resultListNode = firstListNode
            }

            return resultListNode
        }
    }
}