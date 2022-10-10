package solutions.minimumPathSum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumPathSumTest {

    @ParameterizedTest
    @MethodSource("args")
    fun minPathSum(grid: Array<IntArray>, expected: Int) {
        val actual = Solution().minPathSum(grid)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(arrayOf(1,3,1).toIntArray(), arrayOf(1,5,1).toIntArray(), arrayOf(4,2,1).toIntArray()), 7),
            Arguments.of(arrayOf(arrayOf(1,2,3).toIntArray(), arrayOf(4,5,6).toIntArray()), 12),
        )
    }
}