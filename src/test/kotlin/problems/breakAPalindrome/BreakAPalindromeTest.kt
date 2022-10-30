package problems.breakAPalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BreakAPalindromeTest {

    @ParameterizedTest
    @MethodSource
    fun breakPalindrome(palindrome: String, expected: String) {
        val actual = Solution.breakPalindrome(palindrome)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun breakPalindrome() = listOf(
            Arguments.of("abccba", "aaccba"),
            Arguments.of("a", ""),
            Arguments.of("aaaa", "aaab"),
            Arguments.of("aaa", "aab"),
        )
    }
}