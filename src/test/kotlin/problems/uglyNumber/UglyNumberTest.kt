package problems.uglyNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UglyNumberTest {

    @ParameterizedTest
    @MethodSource
    fun isUgly(n: Int, expected: Boolean) {
        val actual = Solution.isUgly(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isUgly() = listOf(
            Arguments.of(6, true),
            Arguments.of(8, true),
            Arguments.of(1, true),
            Arguments.of(14, false),
        )
    }
}