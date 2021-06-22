package solutions.removeDuplicatesFromSortedArray

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class RemoveDuplicatesFromSortedArrayTest {

    @ParameterizedTest
    @MethodSource
    fun removeDuplicates(nums: IntArray, expectedCount: Int, expectedArray: IntArray) {
        val actualCount = Solution().removeDuplicates(nums)
        assertEquals(expectedCount, actualCount)
        assertContentEquals(expectedArray, nums.take(actualCount).toIntArray())
    }

    companion object {
        @JvmStatic
        fun removeDuplicates() = listOf(
            Arguments.of(arrayOf(1,1,2).toIntArray(), 2, arrayOf(1,2).toIntArray()),
            Arguments.of(arrayOf(0,0,1,1,1,2,2,3,3,4).toIntArray(), 5, arrayOf(0,1,2,3,4).toIntArray()),
            Arguments.of(arrayOf<Int>().toIntArray(), 0, arrayOf<Int>().toIntArray()),
            Arguments.of(arrayOf(1,1).toIntArray(), 1, arrayOf(1).toIntArray()),
        )
    }
}