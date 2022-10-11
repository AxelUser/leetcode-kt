package problems.longestPalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestPalindromeTest {

    private val sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun longestPalindrome(s: String, expected: String) {
        val actual = sut.longestPalindrome(s)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun longestPalindrome() = listOf(
            Arguments.of("a", "a"),
            Arguments.of("caab", "aa"),
            Arguments.of("cbab", "bab"),
            Arguments.of("babea", "bab"),
            Arguments.of("racecar", "racecar")
        )
    }
}