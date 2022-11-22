package problems.perfectSquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PerfectSquaresTest {

    @ParameterizedTest
    @MethodSource
    fun numSquares(n: Int, expected: Int) {
        val actual = Solution.numSquares(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun numSquares() = listOf(
            Arguments.of(12, 3),
            Arguments.of(13, 2),
        )
    }
}