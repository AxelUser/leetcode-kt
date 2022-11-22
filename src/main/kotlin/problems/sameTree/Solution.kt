package problems.sameTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(100, "Same Tree", ProblemDifficulty.EASY, "https://leetcode.com/problems/same-tree/")
object Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val pQueue: Queue<TreeNode> = LinkedList()
        val qQueue: Queue<TreeNode> = LinkedList()

        p?.also { pQueue.offer(it) }
        q?.also { qQueue.offer(it) }
        while (pQueue.isNotEmpty() && qQueue.isNotEmpty()) {
            if (pQueue.size != qQueue.size) return false
            repeat(pQueue.size) {
                val pNode = pQueue.poll()
                val qNode = qQueue.poll()
                if (pNode.`val` != qNode.`val` || pNode.left?.`val` != qNode.left?.`val` || pNode.right?.`val` != qNode.right?.`val`) return false
                pNode.left?.also { pQueue.add(it) }
                pNode.right?.also { pQueue.add(it) }
                qNode.left?.also { qQueue.add(it) }
                qNode.right?.also { qQueue.add(it) }
            }
        }

        return pQueue.isEmpty() && qQueue.isEmpty()
    }
}