package problems.shortestPathInAGridWithObstaclesElimination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.parseInt2DArray

internal class ShortestPathInAGridWithObstaclesEliminationTest {

    @ParameterizedTest
    @MethodSource
    fun shortestPath(grid: Array<Array<Int>>, k: Int, expected: Int) {
        val actual = Solution.shortestPath(grid.map { it.toIntArray() }.toTypedArray(), k)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun shortestPath() = listOf(
            Arguments.of(parseInt2DArray("[[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]]"), 1, 6),
            Arguments.of(parseInt2DArray("[[0,1,1],[1,1,1],[1,0,0]]"), 1, -1),
        )
    }
}