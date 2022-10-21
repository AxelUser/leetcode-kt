package problems.binaryTreeInorderTraversal

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    94,
    "Binary Tree Inorder Traversal",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/binary-tree-inorder-traversal/"
)
object Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val res = mutableListOf<Int>()
        val stack = Stack<TreeNode>().apply { push(root) }
        while (stack.isNotEmpty()) {
            val node = stack.peek()
            if (node.left != null) {
                stack.push(node.left)
                node.left = null
                continue
            }

            res.add(node.`val`)
            stack.pop()
            node.right?.apply { stack.push(this) }
        }

        return res
    }
}