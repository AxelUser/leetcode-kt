package problems.convertSortedArrayToBinarySearchTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    108,
    "Convert Sorted Array to Binary Search Tree",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/"
)
object Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        val high = nums.size - 1
        return nums.asTree(0, high)
    }

    private fun IntArray.asTree(low: Int, high: Int): TreeNode? {
        if (low > high) return null

        val mid = low + (high - low) / 2
        val tree = TreeNode(this[mid])

        if (low < mid) {
            tree.left = asTree(low, mid - 1)
        }
        if (mid < high) {
            tree.right = asTree(mid + 1, high)
        }

        return tree
    }
}