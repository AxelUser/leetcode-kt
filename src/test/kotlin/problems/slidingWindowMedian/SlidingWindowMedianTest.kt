package problems.slidingWindowMedian

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class SlidingWindowMedianTest {

    @ParameterizedTest
    @MethodSource
    fun medianSlidingWindow(nums: IntArray, k: Int, expected: DoubleArray) {
        val actual = Solution.medianSlidingWindow(nums, k)
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun medianSlidingWindow() = listOf(
            Arguments.of(
                intArrayOf(1, 3, -1, -3, 5, 3, 6, 7),
                3,
                doubleArrayOf(1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 2, 3, 1, 4, 2),
                3,
                doubleArrayOf(2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000)
            ),
            Arguments.of(
                intArrayOf(2147483647, 2147483647),
                2,
                doubleArrayOf(2147483647.00000)
            ),
        )
    }
}