package problems.flattenBinaryTreeToLinkedList

import problems.common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    114,
    "Flatten Binary Tree to Linked List",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/flatten-binary-tree-to-linked-list/"
)
object Solution {
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        if (root.right != null) stack.push(root.right)
        if (root.left != null) stack.push(root.left)
        val traversed = LinkedList<TreeNode>()
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            traversed.add(node)
            if (node.right != null) stack.push(node.right)
            if (node.left != null) stack.push(node.left)
        }

        root.left = null
        var cur: TreeNode = root
        for (node in traversed) {
            cur.right = TreeNode(node.`val`)
            cur = cur.right!!
        }
    }
}