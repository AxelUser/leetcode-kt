package reverseInt

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReverseIntTest {

    private val sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun reverse(n: Int, expected: Int) {
        assertEquals(expected, sut.reverse(n))
    }

    companion object {
        @JvmStatic
        fun reverse() = listOf(
            Arguments.of(123, 321),
            Arguments.of(1534236469, 0),
        )
    }
}