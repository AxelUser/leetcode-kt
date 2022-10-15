package problems.maximumDepthOfBinaryTree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toBinaryTreeBfs
import kotlin.test.assertEquals

internal class MaximumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("args")
    fun maxDepth(input: Array<Int?>, expected: Int) {
        val actual = Solution.maxDepth(input.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(3, 9, 20, null, null, 15, 7), 3),
            Arguments.of(arrayOf(1, null, 2), 2),
            Arguments.of(arrayOf<Int?>(), 0),
        )
    }
}