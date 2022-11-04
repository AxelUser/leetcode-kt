package problems.reverseVowelsOfAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseVowelsOfAStringTest {

    @ParameterizedTest
    @MethodSource
    fun reverseVowels(s: String, expected: String) {
        val actual = Solution.reverseVowels(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun reverseVowels() = listOf(
            Arguments.of("hello", "holle"),
            Arguments.of("leetcode", "leotcede"),
        )
    }
}