package problems.removeDuplicatesFromSortedArray2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class RemoveDuplicatesFromSortedArray2Test {

    @ParameterizedTest
    @MethodSource("args")
    fun removeDuplicates(nums: IntArray, expectedCount: Int, expectedArray: Array<Int>) {
        val actual = Solution().removeDuplicates(nums)
        assertEquals(expectedCount, actual)
        assertContentEquals(expectedArray, nums.take(actual).toTypedArray())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 1, 1, 2, 2, 3).toIntArray(), 5, arrayOf(1, 1, 2, 2, 3))
        )
    }
}