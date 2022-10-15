package problems.maximumDepthOfBinaryTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    104,
    "Maximum Depth of Binary Tree",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/maximum-depth-of-binary-tree/"
)
object Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        var depth = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            depth++
            val size = queue.size
            repeat(size) {
                val node = queue.poll()
                node.left?.also { queue.add(it) }
                node.right?.also { queue.add(it) }
            }
        }

        return depth
    }
}