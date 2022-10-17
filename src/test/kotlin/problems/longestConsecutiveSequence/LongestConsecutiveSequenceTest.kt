package problems.longestConsecutiveSequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestConsecutiveSequenceTest {

    @ParameterizedTest
    @MethodSource("args")
    fun longestConsecutive(nums: Array<Int>, expected: Int) {
        val actual = Solution.longestConsecutive(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(100, 4, 200, 1, 3, 2), 4),
            Arguments.of(arrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
        )
    }
}