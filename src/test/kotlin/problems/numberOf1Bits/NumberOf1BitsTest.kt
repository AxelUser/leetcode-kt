package problems.numberOf1Bits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOf1BitsTest {

    @ParameterizedTest
    @MethodSource
    fun hammingWeight(n: Int, expected: Int) {
        val actual = Solution.hammingWeight(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun hammingWeight() = listOf(
            Arguments.of(0b00000000000000000000000000001011, 3),
            Arguments.of(0b00000000000000000000000010000000, 1)
        )
    }
}