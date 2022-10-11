package problems.searchInsertPosition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInsertPositionTest {

    @ParameterizedTest
    @MethodSource
    fun searchInsert(nums: Array<Int>, target: Int, expected: Int) {
        assertEquals(expected, Solution().searchInsert(nums.toIntArray(), target))
    }

    companion object {
        @JvmStatic
        fun searchInsert() = listOf(
            Arguments.of(arrayOf(1,3,5,6), 5, 2),
            Arguments.of(arrayOf(1,3,5,6), 2, 1),
            Arguments.of(arrayOf(1,3,5,6), 7, 4),
            Arguments.of(arrayOf(1,3,5,6), 0, 0),
            Arguments.of(arrayOf(1), 0, 0),
        )
    }
}