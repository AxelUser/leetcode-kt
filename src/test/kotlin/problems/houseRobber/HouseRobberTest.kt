package problems.houseRobber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HouseRobberTest {

    @ParameterizedTest
    @MethodSource("args")
    fun rob(nums: IntArray, expected: Int) {
        val actual = Solution().rob(nums)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1,2,3,1).toIntArray(), 4),
            Arguments.of(arrayOf(2,7,9,3,1).toIntArray(), 12),
        )
    }
}