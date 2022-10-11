package problems.climbingStairs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ClimbingStairsTest {

    @ParameterizedTest
    @MethodSource
    fun climbStairs(n: Int, expected: Int) {
        assertEquals(expected, Solution().climbStairs(n))
    }

    companion object {
        @JvmStatic
        fun climbStairs() = listOf(
            Arguments.of(2, 2),
            Arguments.of(3, 3),
        )
    }
}