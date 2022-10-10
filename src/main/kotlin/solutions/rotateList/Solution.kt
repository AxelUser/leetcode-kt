package solutions.rotateList

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import solutions.common.ListNode

@ProblemSolution(61, "Rotate List", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/rotate-list/")
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        val stub = ListNode(0)
        stub.next = head
        var fast = stub
        var slow = stub

        var len = 0
        // get length and tail
        while (fast.next != null) {
            fast = fast.next!!
            len++
        }

        if (len == 0) return null

        val n = k % len
        // find new tail (slow) and thus new head (slow.next)
        for (i in 0 until len - n) {
            slow = slow.next!!
        }

        fast.next = stub.next // connect original tail (fast) with original head (stub.next), now it's circular list
        stub.next = slow.next // save new head after rotation
        slow.next = null // cut tail after rotation

        // return new head
        return stub.next
    }
}