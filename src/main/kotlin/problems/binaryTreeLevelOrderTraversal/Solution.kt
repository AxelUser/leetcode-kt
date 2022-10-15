package problems.binaryTreeLevelOrderTraversal

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    102,
    "Binary Tree Level Order Traversal",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/binary-tree-level-order-traversal/"
)
object Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val res = LinkedList<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val lvlSize = queue.size
            val lvl = ArrayList<Int>(lvlSize)
            for (c in 0 until lvlSize) {
                val node = queue.poll()
                lvl.add(node.`val`)

                node.left?.also { queue.add(it) }
                node.right?.also { queue.add(it) }
            }
            res.add(lvl)
        }

        return res.toList()
    }
}