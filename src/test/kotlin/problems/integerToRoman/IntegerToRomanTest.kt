package problems.integerToRoman

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class IntegerToRomanTest {

    @ParameterizedTest
    @MethodSource
    fun intToRoman(num: Int, expected: String) {
        val actual = Solution.intToRoman(num)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun intToRoman() = listOf(
            Arguments.of(3, "III"),
            Arguments.of(58, "LVIII"),
            Arguments.of(1994, "MCMXCIV"),
        )
    }
}