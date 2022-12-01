package problems.addTwoNumbers

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(2, "Add Two Numbers", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/add-two-numbers/")
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2

        val temp = ListNode(0)
        var sum = temp
        var carry = 0
        while (n1 != null || n2 != null) {
            val add = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + carry
            sum.next = ListNode(add % 10)
            carry = add / 10

            if (n1 != null) {
                n1 = n1.next
            }

            if (n2 != null) {
                n2 = n2.next
            }
            sum = sum.next!!
        }

        if (carry > 0) {
            sum.next = ListNode(carry)
        }

        return temp.next ?: temp
    }
}