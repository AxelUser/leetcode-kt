package problems.invertBinaryTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(226, "Invert Binary Tree", ProblemDifficulty.EASY, "https://leetcode.com/problems/invert-binary-tree/")
object Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.left?.apply { queue.add(this) }
            node.right?.apply { queue.add(this) }
            val temp = node.left
            node.left = node.right
            node.right = temp
        }

        return root
    }
}