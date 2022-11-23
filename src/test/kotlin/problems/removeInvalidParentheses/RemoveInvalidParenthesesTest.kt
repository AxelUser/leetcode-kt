package problems.removeInvalidParentheses

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class RemoveInvalidParenthesesTest {

    @ParameterizedTest
    @MethodSource
    fun removeInvalidParentheses(s: String, expected: List<String>) {
        val actual = Solution().removeInvalidParentheses(s)
        assertContentEquals(expected.sorted(), actual.sorted())
    }

    companion object {
        @JvmStatic
        fun removeInvalidParentheses() = listOf(
            Arguments.of("()())()", listOf("(())()", "()()()")),
            Arguments.of("(a)())()", listOf("(a())()", "(a)()()")),
            Arguments.of(")(", listOf("")),
        )
    }
}