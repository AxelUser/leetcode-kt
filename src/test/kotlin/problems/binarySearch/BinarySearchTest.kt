package problems.binarySearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinarySearchTest {

    @ParameterizedTest
    @MethodSource
    fun search(nums: IntArray, target: Int, expected: Int) {
        val actual = Solution.search(nums, target)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun search() = listOf(
            Arguments.of(intArrayOf(-1, 0, 3, 5, 9, 12), 9, 4),
            Arguments.of(intArrayOf(-1, 0, 3, 5, 9, 12), 2, -1),
        )
    }
}