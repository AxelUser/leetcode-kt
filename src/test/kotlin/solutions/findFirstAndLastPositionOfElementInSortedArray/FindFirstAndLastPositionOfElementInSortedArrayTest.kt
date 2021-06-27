package solutions.findFirstAndLastPositionOfElementInSortedArray

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @ParameterizedTest
    @MethodSource
    fun searchRange(nums: IntArray, target: Int, expected: IntArray) {
        assertContentEquals(expected, Solution().searchRange(nums, target))
    }

    companion object {
        @JvmStatic
        fun searchRange() = listOf(
            Arguments.of(arrayOf(2, 2).toIntArray(), 3, arrayOf(-1,-1).toIntArray()),
            Arguments.of(arrayOf(2, 2).toIntArray(), 2, arrayOf(0, 1).toIntArray()),
            Arguments.of(arrayOf(5,7,7,8,8,10).toIntArray(), 8, arrayOf(3,4).toIntArray()),
            Arguments.of(arrayOf(5,7,7,8,8,10).toIntArray(), 6, arrayOf(-1,-1).toIntArray()),
            Arguments.of(arrayOf<Int>().toIntArray(), 0, arrayOf(-1,-1).toIntArray()),
        )
    }
}