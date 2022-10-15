package problems.validateBinarySearchTree

import common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toBinaryTreeBfs

internal class ValidateBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("args")
    fun isValidBST(root: TreeNode?, expected: Boolean) {
        val actual = Solution.isValidBST(root)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf<Int?>(2, 1, 3).toBinaryTreeBfs(), true),
            Arguments.of(arrayOf<Int?>(2, 1, 3).toBinaryTreeBfs(), true),
            Arguments.of(arrayOf(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null).toBinaryTreeBfs(), true),
            Arguments.of(arrayOf<Int?>(2, 2, 2).toBinaryTreeBfs(), false),
            Arguments.of(arrayOf<Int?>(2147483647).toBinaryTreeBfs(), true),
        )
    }
}