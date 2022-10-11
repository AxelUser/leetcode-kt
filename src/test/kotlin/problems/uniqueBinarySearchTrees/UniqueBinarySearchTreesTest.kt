package problems.uniqueBinarySearchTrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueBinarySearchTreesTest {

    @ParameterizedTest
    @MethodSource
    fun numTrees(n: Int, expected: Int) {
        assertEquals(expected, Solution().numTrees(n))
    }

    companion object {
        @JvmStatic
        fun numTrees() = listOf(
            Arguments.of(3 ,5),
            Arguments.of(1 ,1),
        )
    }
}