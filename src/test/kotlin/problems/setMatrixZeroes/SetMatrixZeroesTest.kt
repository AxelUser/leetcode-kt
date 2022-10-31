package problems.setMatrixZeroes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.stringify2DArray

internal class SetMatrixZeroesTest {

    @ParameterizedTest
    @MethodSource("args")
    fun setZeroes(input: Array<Array<Int>>, expected: Array<Array<Int>>) {
        val actual = input.map { it.toIntArray() }.toTypedArray()
        Solution.setZeroes(actual)

        assertEquals(expected.stringify2DArray(), actual.stringify2DArray())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                arrayOf(arrayOf(1, 1, 1), arrayOf(1, 0, 1), arrayOf(1, 1, 1)),
                arrayOf(arrayOf(1, 0, 1), arrayOf(0, 0, 0), arrayOf(1, 0, 1))
            ),
            Arguments.of(
                arrayOf(arrayOf(0, 1, 2, 0), arrayOf(3, 4, 5, 2), arrayOf(1, 3, 1, 5)),
                arrayOf(arrayOf(0, 0, 0, 0), arrayOf(0, 4, 5, 0), arrayOf(0, 3, 1, 0))
            ),
            Arguments.of(
                arrayOf(arrayOf(1)),
                arrayOf(arrayOf(1))
            ),
            Arguments.of(
                arrayOf(arrayOf(0)),
                arrayOf(arrayOf(0))
            ),
            Arguments.of(
                arrayOf(
                    arrayOf(0, 0, 0, 5),
                    arrayOf(4, 3, 1, 4),
                    arrayOf(0, 1, 1, 4),
                    arrayOf(1, 2, 1, 3),
                    arrayOf(0, 0, 1, 1)
                ),
                arrayOf(
                    arrayOf(0, 0, 0, 0),
                    arrayOf(0, 0, 0, 4),
                    arrayOf(0, 0, 0, 0),
                    arrayOf(0, 0, 0, 3),
                    arrayOf(0, 0, 0, 0)
                )
            ),
        )
    }
}