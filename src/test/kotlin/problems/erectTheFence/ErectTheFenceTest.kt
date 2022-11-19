package problems.erectTheFence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toIntMatrix

internal class ErectTheFenceTest {

    @ParameterizedTest
    @MethodSource
    fun outerTrees(trees: Array<Array<Int>>, expected: Array<Array<Int>>) {
        val actual = Solution.outerTrees(trees.toIntMatrix())
        assertEquals(expected.map { "${it[0]}:${it[1]}" }.toSet(), actual.map { "${it[0]}:${it[1]}" }.toSet())
    }

    companion object {
        @JvmStatic
        fun outerTrees() = listOf(
            Arguments.of(
                arrayOf(
                    arrayOf(1, 1),
                    arrayOf(2, 2),
                    arrayOf(2, 0),
                    arrayOf(2, 4),
                    arrayOf(3, 3),
                    arrayOf(4, 2)
                ), arrayOf(arrayOf(1, 1), arrayOf(2, 0), arrayOf(3, 3), arrayOf(2, 4), arrayOf(4, 2))
            )
        )
    }
}