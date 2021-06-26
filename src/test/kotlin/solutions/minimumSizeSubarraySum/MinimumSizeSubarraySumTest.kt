package solutions.minimumSizeSubarraySum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumSizeSubarraySumTest {

    @ParameterizedTest
    @MethodSource
    fun minSubArrayLen(target: Int, nums: IntArray, expected: Int) {
        assertEquals(expected, Solution().minSubArrayLen(target, nums))
    }

    companion object {
        @JvmStatic
        fun minSubArrayLen() = listOf(
            Arguments.of(15, arrayOf(1,2,3,4,5).toIntArray(), 5),
            Arguments.of(7, arrayOf(2,3,1,2,4,3).toIntArray(), 2),
            Arguments.of(4, arrayOf(1,4,4).toIntArray(), 1),
            Arguments.of(11, arrayOf(1,1,1,1,1,1,1,1).toIntArray(), 0),
        )
    }
}