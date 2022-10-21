package problems.diameterOfBinaryTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    543,
    "Diameter of Binary Tree",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/diameter-of-binary-tree/"
)
class Solution {
    private var globalMax = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return globalMax
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        globalMax = maxOf(globalMax, left + right)
        return maxOf(left, right) + 1
    }
}