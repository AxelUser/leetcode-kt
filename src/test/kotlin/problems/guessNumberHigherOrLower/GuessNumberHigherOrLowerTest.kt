package problems.guessNumberHigherOrLower

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class GuessNumberHigherOrLowerTest {

    @ParameterizedTest
    @MethodSource
    fun guessNumber(n: Int, expected: Int) {
        val actual = Solution().apply { picked = expected }.guessNumber(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun guessNumber() = listOf(
            Arguments.of(10, 6),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
        )
    }
}