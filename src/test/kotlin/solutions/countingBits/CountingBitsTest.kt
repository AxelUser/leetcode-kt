package solutions.countingBits

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class CountingBitsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun countBits(n: Int, expected: IntArray) {
        val actual = Solution().countBits(n)
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(2, arrayOf(0, 1, 1).toIntArray()),
            Arguments.of(5, arrayOf(0, 1, 1, 2, 1, 2).toIntArray())
        )
    }
}