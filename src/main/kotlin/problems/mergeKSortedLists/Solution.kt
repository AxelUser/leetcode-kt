package problems.mergeKSortedLists

import common.ListNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    23,
    "Merge k Sorted Lists",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/merge-k-sorted-lists/"
)
object Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val resHead = ListNode(0)
        var resTail = resHead

        while (true) {
            var minIdx = 0
            var minNode: ListNode? = null
            // find first minimal not-null node in array and it's index in array
            for ((idx, listHead) in lists.withIndex()) {
                if (listHead == null) continue
                if (minNode == null || listHead.`val` < minNode.`val`) {
                    minNode = listHead
                    minIdx = idx
                }
            }

            // if all nodes are null - return result
            if (minNode == null) break

            // add node to result
            resTail.next = ListNode(minNode.`val`)
            resTail = resTail.next!!

            // modify head at index with minNode.next
            lists[minIdx] = minNode.next
        }

        return resHead.next
    }
}