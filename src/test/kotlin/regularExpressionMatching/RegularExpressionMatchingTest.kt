package regularExpressionMatching

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RegularExpressionMatchingTest {

    @ParameterizedTest
    @MethodSource
    fun isMatch(text: String, pattern: String, expected: Boolean) {
        val sut = Solution()
        assertEquals(expected, sut.isMatch(text, pattern))
    }

    companion object {
        @JvmStatic
        fun isMatch() = listOf(
            Arguments.of("aa", "a", false),
            Arguments.of("aa", "a*", true),
            Arguments.of("ab", ".*", true),
            Arguments.of("aab", "c*a*b", true),
            Arguments.of("mississippi", "mis*is*p*.", false),
        )
    }
}