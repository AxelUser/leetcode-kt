package problems.generateParentheses

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertTrue

internal class GenerateParenthesesTest {

    @ParameterizedTest
    @MethodSource
    fun generateParenthesis(n: Int, expected: List<String>) {
        val actual = Solution().generateParenthesis(n)
        assertTrue(actual.size == expected.size && actual.containsAll(expected) && expected.containsAll(actual))
    }

    companion object {
        @JvmStatic
        fun generateParenthesis() = listOf(
            Arguments.of(3, listOf("((()))","(()())","(())()","()(())","()()()")),
            Arguments.of(1, listOf("()")),
        )
    }
}