package solutions.firstMissingPositive

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FirstMissingPositiveTest {

    @ParameterizedTest
    @MethodSource("args")
    fun firstMissingPositive(nums: IntArray, expected: Int) {
        val actual = Solution().firstMissingPositive(nums)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 2, 0).toIntArray(), 3),
            Arguments.of(arrayOf(3, 4, -1, 1).toIntArray(), 2),
            Arguments.of(arrayOf(7, 8, 9, 11, 12).toIntArray(), 1),
        )
    }
}