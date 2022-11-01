package problems.whereWillTheBallFall

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.parseInt2DArray
import utils.toIntMatrix
import kotlin.test.assertContentEquals

internal class WhereWillTheBallFallTest {

    @ParameterizedTest
    @MethodSource
    fun findBall(grid: Array<Array<Int>>, expected: Array<Int>) {
        val actual = Solution.findBall(grid.toIntMatrix()).toTypedArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findBall() = listOf(
            Arguments.of(
                parseInt2DArray("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]"),
                arrayOf(1, -1, -1, -1, -1)
            ),
            Arguments.of(parseInt2DArray("[[-1]]"), arrayOf(-1)),
            Arguments.of(
                parseInt2DArray("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]"),
                arrayOf(0, 1, 2, 3, 4, -1)
            ),
        )
    }
}