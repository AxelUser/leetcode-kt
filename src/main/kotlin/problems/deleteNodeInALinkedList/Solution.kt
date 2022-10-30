package problems.deleteNodeInALinkedList

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    237,
    "Delete Node in a Linked List",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/delete-node-in-a-linked-list/"
)
object Solution {
    fun deleteNode(node: ListNode?) {
        node!!.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}