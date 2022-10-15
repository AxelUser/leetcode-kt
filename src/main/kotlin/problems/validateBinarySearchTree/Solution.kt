package problems.validateBinarySearchTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    98,
    "Validate Binary Search Tree",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/validate-binary-search-tree/"
)
object Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        // should be unreachable due to constraints - tree has at least one element
        if (root == null) return false

        val stack = Stack<Triple<TreeNode, Int?, Int?>>()

        stack.push(Triple(root, null, null))
        while (stack.isNotEmpty()) {
            val (node, curMin, curMax) = stack.pop()
            if ((curMin != null && node.`val` <= curMin) || (curMax != null && node.`val` >= curMax)) return false

            if (node.right != null) {
                stack.push(Triple(node.right!!, node.`val`, curMax))
            }

            if (node.left != null) {
                stack.push(Triple(node.left!!, curMin, node.`val`))
            }
        }

        return true
    }
}