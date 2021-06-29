package solutions.longestCommonSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestCommonSubsequenceTest {

    @ParameterizedTest
    @MethodSource
    fun longestCommonSubsequence(text1: String, text2: String, expected: Int) {
        assertEquals(expected, Solution().longestCommonSubsequence(text1, text2))
    }

    companion object {
        @JvmStatic
        fun longestCommonSubsequence() = listOf(
            Arguments.of("abcde", "ace", 3),
            Arguments.of("abc", "abc", 3),
            Arguments.of("abc", "def", 0),
            Arguments.of("xmjyauz", "mzjawxu", 4),
        )
    }
}