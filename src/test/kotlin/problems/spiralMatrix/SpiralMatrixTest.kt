package problems.spiralMatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SpiralMatrixTest {

    @ParameterizedTest
    @MethodSource("args")
    fun spiralOrder(matrix: Array<IntArray>, expected: List<Int>) {
        val actual = Solution().spiralOrder(matrix)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                arrayOf(
                    arrayOf(1, 2, 3).toIntArray(),
                    arrayOf(4, 5, 6).toIntArray(),
                    arrayOf(7, 8, 9).toIntArray()
                ), listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
            )
        )
    }
}