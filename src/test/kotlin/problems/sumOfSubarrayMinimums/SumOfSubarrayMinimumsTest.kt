package problems.sumOfSubarrayMinimums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SumOfSubarrayMinimumsTest {

    @ParameterizedTest
    @MethodSource
    fun sumSubarrayMins(arr: IntArray, expected: Int) {
        val actual = Solution.sumSubarrayMins(arr)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun sumSubarrayMins() = listOf(
            Arguments.of(intArrayOf(3, 1, 2, 4), 17),
            Arguments.of(intArrayOf(11, 81, 94, 43, 3), 444),
        )
    }
}