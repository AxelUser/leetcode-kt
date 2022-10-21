package problems.diameterOfBinaryTree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toBinaryTreeBfs

internal class DiameterOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource
    fun diameterOfBinaryTree(input: Array<Int?>, expected: Int) {
        val actual = Solution().diameterOfBinaryTree(input.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun diameterOfBinaryTree() = listOf(
            Arguments.of(arrayOf<Int?>(1, 2, 3, 4, 5), 3),
            Arguments.of(arrayOf<Int?>(1, 2), 1),
            Arguments.of(arrayOf<Int?>(1, 2, 3, 4, 5, null, null, null, 6, null, 7), 4),
        )
    }
}