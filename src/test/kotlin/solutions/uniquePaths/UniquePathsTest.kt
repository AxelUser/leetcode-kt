package solutions.uniquePaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniquePathsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun uniquePaths(m: Int, n: Int, expected: Int) {
        val actual = Solution().uniquePaths(m, n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(3, 7, 28)
        )
    }
}