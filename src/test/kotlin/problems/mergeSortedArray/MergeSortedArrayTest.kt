package problems.mergeSortedArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("args")
    fun merge(nums1: Array<Int>, m: Int, nums2: Array<Int>, n: Int, expected: Array<Int>) {
        val actual = nums1.toIntArray()
        Solution().merge(actual, m, nums2.toIntArray(), n)
        assertContentEquals(expected.toIntArray(), actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 2, 3, 0, 0, 0), 3, arrayOf(2, 5, 6), 3, arrayOf(1, 2, 2, 3, 5, 6)),
            Arguments.of(arrayOf(1), 1, emptyArray<Int>(), 0, arrayOf(1)),
            Arguments.of(arrayOf(0), 0, arrayOf(1), 1, arrayOf(1)),
        )
    }
}