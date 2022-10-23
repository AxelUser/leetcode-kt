package problems.findTheDifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindTheDifferenceTest {

    @ParameterizedTest
    @MethodSource
    fun findTheDifference(s: String, t: String, expected: Char) {
        val actual = Solution.findTheDifference(s, t)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findTheDifference() = listOf(
            Arguments.of("abcd", "abcde", 'e'),
            Arguments.of("", "y", 'y'),
            Arguments.of("y", "yy", 'y'),
            Arguments.of("leetcode", "leeetcode", 'e'),
        )
    }
}