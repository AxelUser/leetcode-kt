package problems.reverseBits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseBitsTest {

    @ParameterizedTest
    @MethodSource
    fun reverseBits(n: Int, expected: Int) {
        val actual = Solution.reverseBits(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun reverseBits() = listOf(
            Arguments.of(43261596, 964176192),
            Arguments.of(-3, -1073741825),
        )
    }
}