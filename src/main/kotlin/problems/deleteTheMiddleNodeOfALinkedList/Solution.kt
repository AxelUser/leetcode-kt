package problems.deleteTheMiddleNodeOfALinkedList

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    2095,
    "Delete the Middle Node of a Linked List",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/"
)
object Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        val temp = ListNode(0)
        temp.next = head
        var fast: ListNode? = temp
        var slow: ListNode? = temp

        while (fast?.next != null) {
            fast = fast.next?.next
            if (fast != null) {
                slow = slow?.next
            }
        }

        slow!!.next = slow.next?.next

        return temp.next
    }
}