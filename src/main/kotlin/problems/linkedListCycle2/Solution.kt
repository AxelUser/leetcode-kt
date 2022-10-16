package problems.linkedListCycle2

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    142,
    "Linked List Cycle II",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/linked-list-cycle-ii/"
)
object Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        var slow = head
        var fast = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (slow == fast) {
                slow = head
                while (slow != fast) {
                    slow = slow!!.next
                    fast = fast!!.next
                }

                return slow
            }
        }

        return null
    }
}