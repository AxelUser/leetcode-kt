package solutions.searchInRotatedSortedArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource
    fun search(nums: IntArray, target: Int, expected: Int) {
        assertEquals(expected, Solution().search(nums, target))
    }

    companion object {
        @JvmStatic
        fun search() = listOf(
            Arguments.of(arrayOf(4,5,6,7,0,1,2).toIntArray(), 0, 4),
            Arguments.of(arrayOf(4,5,6,7,0,1).toIntArray(), 7, 3),
            Arguments.of(arrayOf(4,5,6,7,0,1,2).toIntArray(), 3, -1),
            Arguments.of(arrayOf(1).toIntArray(), 0, -1),
            Arguments.of(arrayOf(1).toIntArray(), 1, 0),
        )
    }
}