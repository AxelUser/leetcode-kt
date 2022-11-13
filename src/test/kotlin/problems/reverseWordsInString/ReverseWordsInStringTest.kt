package problems.reverseWordsInString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseWordsInStringTest {

    @ParameterizedTest
    @MethodSource
    fun reverseWords(s: String, expected: String) {
        val actual = Solution.reverseWords(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun reverseWords() = listOf(
            Arguments.of("the sky is blue", "blue is sky the"),
            Arguments.of("  hello world  ", "world hello"),
            Arguments.of("a good   example", "example good a"),
            Arguments.of("          ", ""),
        )
    }
}