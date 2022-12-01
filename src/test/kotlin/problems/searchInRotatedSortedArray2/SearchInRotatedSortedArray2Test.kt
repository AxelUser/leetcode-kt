package problems.searchInRotatedSortedArray2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInRotatedSortedArray2Test {

    @ParameterizedTest
    @MethodSource
    fun search(nums: IntArray, target: Int, expected: Boolean) {
        assertEquals(expected, Solution().search(nums, target))
    }

    companion object {
        @JvmStatic
        fun search() = listOf(
            Arguments.of(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0, true),
            Arguments.of(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3, false),
            Arguments.of(intArrayOf(1, 1, 1, 0, 1), 0, true),
        )
    }
}