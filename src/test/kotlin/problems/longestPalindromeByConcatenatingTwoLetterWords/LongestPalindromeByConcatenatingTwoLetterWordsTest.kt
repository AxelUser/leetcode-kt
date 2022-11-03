package problems.longestPalindromeByConcatenatingTwoLetterWords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestPalindromeByConcatenatingTwoLetterWordsTest {

    @ParameterizedTest
    @MethodSource
    fun longestPalindrome(words: Array<String>, expected: Int) {
        val actual = Solution.longestPalindrome(words)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun longestPalindrome() = listOf(
            Arguments.of(arrayOf("lc", "cl", "gg"), 6),
            Arguments.of(arrayOf("ab", "ty", "yt", "lc", "cl", "ab"), 8),
            Arguments.of(arrayOf("cc", "ll", "xx"), 2),
            Arguments.of(arrayOf("mc"), 0),
        )
    }
}