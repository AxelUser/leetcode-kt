package problems.balancedBinaryTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    110,
    "Balanced Binary Tree",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/balanced-binary-tree/"
)
object Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return depth(root) >= 0
    }

    private fun depth(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDepth = depth(node.left)
        if (leftDepth == -1) return -1

        val rightDepth = depth(node.right)
        if (rightDepth == -1) return -1

        if (Math.abs(rightDepth - leftDepth) > 1) return -1

        return maxOf(leftDepth, rightDepth) + 1
    }
}