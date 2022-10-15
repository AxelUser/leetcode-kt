package problems.searchA2DMatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.parseInt2DArray

internal class SearchA2DMatrixTest {

    @ParameterizedTest
    @MethodSource("args")
    fun searchMatrix(matrix: Array<Array<Int>>, target: Int, expected: Boolean) {
        val actual = Solution.searchMatrix(matrix.map { it.toIntArray() }.toTypedArray(), target)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(parseInt2DArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3, true),
            Arguments.of(parseInt2DArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 13, false),
        )
    }
}