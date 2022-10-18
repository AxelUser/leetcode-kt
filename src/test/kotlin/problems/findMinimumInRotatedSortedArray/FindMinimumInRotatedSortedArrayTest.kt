package problems.findMinimumInRotatedSortedArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindMinimumInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("args")
    fun findMin(nums: Array<Int>, expected: Int) {
        val actual = Solution.findMin(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(3, 4, 5, 1, 2), 1),
            Arguments.of(arrayOf(4, 5, 6, 7, 0, 1, 2), 0),
            Arguments.of(arrayOf(11, 13, 15, 17), 11),
            Arguments.of(arrayOf(1), 1),
            Arguments.of(arrayOf(2, 1), 1),
            Arguments.of(arrayOf(3, 1, 2), 1),
            Arguments.of(arrayOf(4, 5, 1, 2, 3), 1),
            Arguments.of(arrayOf(2, 3, 4, 5, 1), 1),
        )
    }
}