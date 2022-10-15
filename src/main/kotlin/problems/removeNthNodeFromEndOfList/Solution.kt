package problems.removeNthNodeFromEndOfList

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(19, "Remove Nth Node From End of List", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/remove-nth-node-from-end-of-list/")
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var nth: ListNode? = null
        var preNth: ListNode? = null

        var count = 0
        var cur = head

        while (cur != null) {
            count++
            when {
                count == n -> {
                    nth = head
                }
                count > n -> {
                    preNth = nth
                    nth = nth!!.next
                }
            }

            cur = cur.next
        }

        if (nth != null) {
            if(preNth == null) return nth.next

            preNth.next = nth.next
        }

        return head
    }
}