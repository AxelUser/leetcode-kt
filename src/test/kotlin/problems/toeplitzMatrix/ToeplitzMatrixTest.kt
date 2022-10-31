package problems.toeplitzMatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.parseInt2DArray
import utils.toIntMatrix

internal class ToeplitzMatrixTest {

    @ParameterizedTest
    @MethodSource
    fun isToeplitzMatrix(matrix: Array<Array<Int>>, expected: Boolean) {
        val actual = Solution.isToeplitzMatrix(matrix.toIntMatrix())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isToeplitzMatrix() = listOf(
            Arguments.of(parseInt2DArray("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]"), true),
            Arguments.of(parseInt2DArray("[[1,2],[2,2]]"), false),
            Arguments.of(parseInt2DArray("[[1,2,2,4]]"), true),
        )
    }
}