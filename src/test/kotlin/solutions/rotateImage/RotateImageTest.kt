package solutions.rotateImage

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class RotateImageTest {

    @ParameterizedTest
    @MethodSource
    fun rotate(matrix: Array<IntArray>, expected: Array<IntArray>) {
        Solution().rotate(matrix)
        for (i in matrix.indices) {
            assertContentEquals(expected[i], matrix[i])
        }
    }

    companion object {
        @JvmStatic
        fun rotate() = listOf(
            Arguments.of(
                arrayOf(arrayOf(1,2,3).toIntArray(),arrayOf(4,5,6).toIntArray(), arrayOf(7,8,9).toIntArray()),
                arrayOf(arrayOf(7,4,1).toIntArray(),arrayOf(8,5,2).toIntArray(), arrayOf(9,6,3).toIntArray()),
            ),
            Arguments.of(
                arrayOf(arrayOf(5,1,9,11).toIntArray(),arrayOf(2,4,8,10).toIntArray(), arrayOf(13,3,6,7).toIntArray(), arrayOf(15,14,12,16).toIntArray()),
                arrayOf(arrayOf(15,13,2,5).toIntArray(),arrayOf(14,3,4,1).toIntArray(), arrayOf(12,6,8,9).toIntArray(), arrayOf(16,7,10,11).toIntArray()),
            )
        )
    }
}