package solutions.mergeTwoSortedLists

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import solutions.common.ListNode

@ProblemSolution(21, "Merge Two Sorted Lists", ProblemDifficulty.EASY,
    "https://leetcode.com/problems/merge-two-sorted-lists/")
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var curL1 = l1
        var curL2 = l2
        var sorted: ListNode? = ListNode(0)
        var sortedTail = sorted

        while (curL1 != null || curL2 != null) {
            var `val` = 0
            when {
                curL1 == null -> {
                    `val` = curL2!!.`val`
                    curL2 = curL2.next
                }
                curL2 == null -> {
                    `val` = curL1.`val`
                    curL1 = curL1.next
                }
                curL2.`val` <= curL1.`val` -> {
                    `val` = curL2.`val`
                    curL2 = curL2.next
                }
                curL1.`val` <= curL2.`val` -> {
                    `val` = curL1.`val`
                    curL1 = curL1.next
                }
            }
            sortedTail?.next = ListNode(`val`)

            sortedTail = sortedTail?.next
        }

        // Remove first dummy head
        sorted = sorted?.next

        return sorted
    }
}