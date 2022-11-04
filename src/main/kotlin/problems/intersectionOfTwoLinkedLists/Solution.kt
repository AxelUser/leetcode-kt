package problems.intersectionOfTwoLinkedLists

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    160,
    "Intersection of Two Linked Lists",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/intersection-of-two-linked-lists/"
)
object Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var p1 = headA
        var p2 = headB

        while (p1 != p2) {
            p1 = if (p1 != null) p1.next else headB
            p2 = if (p2 != null) p2.next else headA
        }

        return p1
    }
}