package problems.countCompleteTreeNodes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toBinaryTreeBfs

internal class CountCompleteTreeNodesTest {

    @ParameterizedTest
    @MethodSource
    fun countNodes(input: Array<Int?>, expected: Int) {
        val actual = Solution.countNodes(input.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun countNodes() = listOf(
            Arguments.of(arrayOf<Int?>(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(arrayOf<Int?>(), 0),
            Arguments.of(arrayOf<Int?>(1), 1),
        )
    }
}