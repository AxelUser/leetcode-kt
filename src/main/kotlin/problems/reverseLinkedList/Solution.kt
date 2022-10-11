package problems.reverseLinkedList

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import problems.common.ListNode

@ProblemSolution(206, "Reverse Linked List", ProblemDifficulty.EASY, "https://leetcode.com/problems/reverse-linked-list/")
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var newHead: ListNode? = ListNode(head.`val`)
        var cur = head.next
        while (cur != null) {
            val h = ListNode(cur.`val`)
            h.next = newHead

            newHead = h
            cur = cur.next
        }

        return newHead
    }
}