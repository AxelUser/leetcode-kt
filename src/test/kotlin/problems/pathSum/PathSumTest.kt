package problems.pathSum

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toBinaryTreeBfs
import kotlin.test.assertEquals

internal class PathSumTest {

    @ParameterizedTest
    @MethodSource("args")
    fun hasPathSum(input: Array<Int?>, target: Int, expected: Boolean) {
        val actual = Solution.hasPathSum(input.toBinaryTreeBfs(), target)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22, true),
            Arguments.of(arrayOf(1, 2, 3), 5, false),
            Arguments.of(arrayOf<Int?>(), 0, false),
        )
    }
}