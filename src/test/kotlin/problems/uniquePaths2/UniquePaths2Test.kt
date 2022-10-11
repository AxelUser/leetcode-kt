package problems.uniquePaths2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniquePaths2Test {

    @ParameterizedTest
    @MethodSource("args")
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>, expected: Int) {
        val actual = Solution().uniquePathsWithObstacles(obstacleGrid)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(listOf(0, 0, 0).toIntArray(), listOf(0, 1, 0).toIntArray(), listOf(0, 0, 0).toIntArray()), 2),
            Arguments.of(arrayOf(listOf(1, 0).toIntArray()), 0)
        )
    }
}