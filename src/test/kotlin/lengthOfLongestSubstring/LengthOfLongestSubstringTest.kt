package lengthOfLongestSubstring

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LengthOfLongestSubstringTest {

    private val sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun lengthOfLongestSubstring(s: String, expected: Int) {
        val actual = sut.lengthOfLongestSubstring(s)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun lengthOfLongestSubstring() = listOf(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("pwwkpew", 4),
            Arguments.of("pwwkpewn", 5),
            Arguments.of("pwwkcewnp", 6),
            Arguments.of("", 0)
        )
    }
}