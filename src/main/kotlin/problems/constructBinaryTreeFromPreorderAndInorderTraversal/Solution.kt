package problems.constructBinaryTreeFromPreorderAndInorderTraversal

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    105,
    "Construct Binary Tree from Preorder and Inorder Traversal",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/"
)
object Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inMap = HashMap<Int, Int>()
        for (i in inorder.indices) inMap[inorder[i]] = i
        return buildTreeDfs(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1, inMap)
    }

    private fun buildTreeDfs(
        preorder: IntArray,
        preLow: Int,
        preHigh: Int,
        inorder: IntArray,
        inLow: Int,
        inHigh: Int,
        inMap: Map<Int, Int>
    ): TreeNode? {
        if (preLow > preHigh || inLow > inHigh) return null

        val root = TreeNode(preorder[preLow])
        val inRoot = inMap.getValue(preorder[preLow])
        val nodesInLeftSubtree = inRoot - inLow

        root.left = buildTreeDfs(preorder, preLow + 1, preLow + nodesInLeftSubtree, inorder, inLow, inRoot - 1, inMap)
        root.right =
            buildTreeDfs(preorder, preLow + nodesInLeftSubtree + 1, preHigh, inorder, inRoot + 1, inHigh, inMap)
        return root
    }
}