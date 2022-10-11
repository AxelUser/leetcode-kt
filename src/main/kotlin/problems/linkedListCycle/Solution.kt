package problems.linkedListCycle

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import problems.common.ListNode

@ProblemSolution(141, "Linked List Cycle", ProblemDifficulty.EASY, "https://leetcode.com/problems/linked-list-cycle/")
class Solution {
    fun hasCycleWithHashMap(head: ListNode?): Boolean {
        val set = HashSet<ListNode?>()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) return true

            set.add(cur)
            cur = cur.next
        }

        return false
    }

    fun hasCycleWithFastAndSlowPointer(head: ListNode?): Boolean {
        if (head == null) return false

        var slow = head
        var fast = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow!!.next

            if (fast == slow) return true
        }

        return false
    }
}