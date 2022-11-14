package problems.mostStonesRemovedWithSameRowOrColumn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MostStonesRemovedWithSameRowOrColumnTest {

    @ParameterizedTest
    @MethodSource
    fun removeStones(stones: Array<Array<Int>>, expected: Int) {
        val actual = Solution().removeStones(stones.map { it.toIntArray() }.toTypedArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun removeStones() = listOf(
            Arguments.of(
                arrayOf(
                    arrayOf(0, 0),
                    arrayOf(0, 1),
                    arrayOf(1, 0),
                    arrayOf(1, 2),
                    arrayOf(2, 1),
                    arrayOf(2, 2)
                ), 5
            ),
            Arguments.of(
                arrayOf(
                    arrayOf(0, 0),
                    arrayOf(0, 2),
                    arrayOf(1, 1),
                    arrayOf(2, 0),
                    arrayOf(2, 2),
                ), 3
            )
        )
    }
}