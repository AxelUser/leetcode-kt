package problems.longestIncreasingSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestIncreasingSubsequenceTest {

    @ParameterizedTest
    @MethodSource
    fun lengthOfLIS(nums: IntArray, expected: Int) {
        assertEquals(expected, Solution().lengthOfLIS(nums))
    }

    companion object {
        @JvmStatic
        fun lengthOfLIS() = listOf(
            Arguments.of(arrayOf(10,9,2,5,3,7,101,18).toIntArray(), 4),
            Arguments.of(arrayOf(0,1,0,3,2,3).toIntArray(), 4),
            Arguments.of(arrayOf(7,7,7,7,7,7,7).toIntArray(), 1),
        )
    }
}