package problems.stringToInteger

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StringToIntegerTest {

    @ParameterizedTest
    @MethodSource("args")
    fun myAtoi(s: String, expected: Int) {
        val actual = Solution().myAtoi(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("42", 42),
            Arguments.of("-42", -42),
            Arguments.of("+42", 42),
            Arguments.of("        -42", -42),
            Arguments.of("        42", 42),
            Arguments.of("        4s2", 4),
            Arguments.of("2147483648", Int.MAX_VALUE),
            Arguments.of("-2147483649", Int.MIN_VALUE),
            Arguments.of(Int.MIN_VALUE.toString(), Int.MIN_VALUE),
            Arguments.of(Int.MAX_VALUE.toString(), Int.MAX_VALUE),
            Arguments.of(" ", 0),
        )
    }
}