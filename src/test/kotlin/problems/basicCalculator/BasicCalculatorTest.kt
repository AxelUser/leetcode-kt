package problems.basicCalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BasicCalculatorTest {

    @ParameterizedTest
    @MethodSource("args")
    fun calculate(s: String, expected: Int) {
        val actual = Solution().calculate(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("(1 + 2) + 3", 6),
            Arguments.of("1 + 2 - 3", 0),
            Arguments.of("-(1 + 2)", -3),
            Arguments.of("1 + 1", 2),
            Arguments.of("2-1 + 2 ", 3),
            Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
            Arguments.of("1-(-2)", 3),
        )
    }
}