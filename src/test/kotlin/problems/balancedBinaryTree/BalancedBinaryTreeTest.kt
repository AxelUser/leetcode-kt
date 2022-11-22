package problems.balancedBinaryTree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toBinaryTreeBfs

internal class BalancedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource
    fun isBalanced(root: Array<Int?>, expected: Boolean) {
        val actual = Solution.isBalanced(root.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isBalanced() = listOf(
            Arguments.of(arrayOf<Int?>(3, 9, 20, null, null, 15, 7), true),
            Arguments.of(arrayOf<Int?>(1, 2, 2, 3, 3, null, null, 4, 4), false),
            Arguments.of(arrayOf<Int?>(), true),
        )
    }
}