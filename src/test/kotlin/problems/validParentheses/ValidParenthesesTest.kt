package problems.validParentheses

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource
    fun isValid(s: String, expected: Boolean) {
        assertEquals(expected, Solution().isValid(s))
    }

    companion object {
        @JvmStatic
        fun isValid() = listOf(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([)]", false),
            Arguments.of("{[]}", true),
            Arguments.of("(", false),
            Arguments.of(")", false),
        )
    }
}