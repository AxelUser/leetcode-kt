package problems.maxSubArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxSubArrayTest {

    private val sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun maxSubArray(nums: IntArray, expected: Int) {
        assertEquals(expected, sut.maxSubArray(nums))
    }

    companion object {
        @JvmStatic
        fun maxSubArray() = listOf(
            Arguments.of(arrayOf(-2,1,-3,4,-1,2,1,-5,4).toIntArray(), 6),
            Arguments.of(arrayOf(1).toIntArray(), 1),
            Arguments.of(arrayOf(5,4,-1,7,8).toIntArray(), 23),
        )
    }
}