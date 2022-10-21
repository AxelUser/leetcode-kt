package problems.palindromeLinkedList

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    234,
    "Palindrome Linked List",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/palindrome-linked-list/"
)
object Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val stack = Stack<ListNode>().apply { push(head) }
        while (stack.peek().next != null) {
            stack.push(stack.peek().next)
        }

        var cur = head
        for (i in 0 until stack.size / 2) {
            if (cur!!.`val` != stack.pop().`val`) return false
            cur = cur.next
        }

        return true
    }
}