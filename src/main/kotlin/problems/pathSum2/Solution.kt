package problems.pathSum2

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(113, "Path Sum II", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/path-sum-ii/")
class Solution {
    private val res = mutableListOf<List<Int>>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        dfs(root, targetSum, mutableListOf())
        return res
    }

    private fun dfs(node: TreeNode?, sum: Int, path: MutableList<Int>) {
        if (node == null) return

        val remaining = sum - node.`val`
        path.add(node.`val`)

        if (node.left == null && node.right == null) {
            if (remaining == 0) {
                res.add(path.toList())
            }
        } else {
            node.left?.apply { dfs(this, remaining, path) }
            node.right?.apply { dfs(this, remaining, path) }
        }

        path.removeAt(path.lastIndex)
    }
}