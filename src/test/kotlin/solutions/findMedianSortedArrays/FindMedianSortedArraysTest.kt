package solutions.findMedianSortedArrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindMedianSortedArraysTest {

    private val sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray, expected: Double) {
        val actual = sut.findMedianSortedArrays(nums1, nums2)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findMedianSortedArrays() = listOf(
            Arguments.of(arrayOf(1, 3, 5, 6).toIntArray(), arrayOf(2, 4, 7, 8).toIntArray(), 4.5),
            Arguments.of(arrayOf(1, 3).toIntArray(), arrayOf(2).toIntArray(), 2.0),
            Arguments.of(arrayOf(1, 2).toIntArray(), arrayOf(3, 4).toIntArray(), 2.5),
            Arguments.of(arrayOf(0, 0).toIntArray(), arrayOf(0, 0).toIntArray(), 0.0),
            Arguments.of(IntArray(0), arrayOf(1).toIntArray(), 1.0),
            Arguments.of(arrayOf(2).toIntArray(), IntArray(0), 2.0)
        )
    }
}