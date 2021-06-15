package solutions.longestValidParentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestValidParenthesesTest {

    @ParameterizedTest
    @MethodSource
    fun longestValidParentheses(s: String, expected: Int) {
        val sut = Solution()
        assertEquals(expected, sut.longestValidParentheses(s))
    }

    companion object {
        @JvmStatic
        fun longestValidParentheses() = listOf(
            Arguments.of("(()", 2),
            Arguments.of(")()())", 4),
            Arguments.of("", 0),
        )
    }
}