package solutions.palindromeNumber

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class PalindromeNumberTest {

    @ParameterizedTest
    @MethodSource
    fun isPalindrome(x: Int, expected: Boolean) {
        assertEquals(expected, Solution().isPalindrome(x))
    }

    companion object {
        @JvmStatic
        fun isPalindrome() = listOf(
            Arguments.of(11, true),
            Arguments.of(121, true),
            Arguments.of(12321, true),
            Arguments.of(12331, false),
            Arguments.of(-121, false),
            Arguments.of(10, false),
            Arguments.of(-101, false),
            Arguments.of(0, true),
            Arguments.of(-1, false),
            Arguments.of(-10, false),
        )
    }
}