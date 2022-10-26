package problems.continuousSubarraySum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContinuousSubarraySumTest {

    @ParameterizedTest
    @MethodSource
    fun checkSubarraySum(nums: Array<Int>, k: Int, expected: Boolean) {
        val actual = Solution.checkSubarraySum(nums.toIntArray(), k)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun checkSubarraySum() = listOf(
            Arguments.of(arrayOf(23, 2, 4, 6, 7), 6, true),
            Arguments.of(arrayOf(23, 2, 6, 4, 7), 6, true),
            Arguments.of(arrayOf(23, 2, 6, 4, 7), 13, false),
        )
    }
}