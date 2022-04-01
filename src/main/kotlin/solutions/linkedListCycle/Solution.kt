package solutions.linkedListCycle

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import solutions.common.ListNode

@ProblemSolution(141, "Linked List Cycle", ProblemDifficulty.EASY, "https://leetcode.com/problems/linked-list-cycle/")
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val set = HashSet<ListNode?>()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) return true

            set.add(cur)
            cur = cur.next
        }

        return false
    }
}