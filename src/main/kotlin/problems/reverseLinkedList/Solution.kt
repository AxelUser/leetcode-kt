package problems.reverseLinkedList

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(206, "Reverse Linked List", ProblemDifficulty.EASY, "https://leetcode.com/problems/reverse-linked-list/")
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var prev = head
        var cur = head.next
        prev.next = null
        while (cur != null) {
            val cNext = cur.next
            cur.next = prev
            prev = cur
            cur = cNext
        }

        return prev
    }
}