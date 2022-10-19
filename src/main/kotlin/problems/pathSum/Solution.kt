package problems.pathSum

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(112, "Path Sum", ProblemDifficulty.EASY, "https://leetcode.com/problems/path-sum/")
object Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.add(root to 0)

        while (queue.isNotEmpty()) {
            val (node, prevSum) = queue.poll()
            val curSum = node.`val` + prevSum
            if (curSum == targetSum && (node.left ?: node.right) == null) return true
            node.left?.also { queue.add(it to curSum) }
            node.right?.also { queue.add(it to curSum) }
        }

        return false
    }
}