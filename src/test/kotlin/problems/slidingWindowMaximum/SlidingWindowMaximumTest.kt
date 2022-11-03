package problems.slidingWindowMaximum

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class SlidingWindowMaximumTest {

    @ParameterizedTest
    @MethodSource
    fun maxSlidingWindow(nums: Array<Int>, k: Int, expected: Array<Int>) {
        val actual = Solution.maxSlidingWindow(nums.toIntArray(), k).toTypedArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun maxSlidingWindow() = listOf(
            Arguments.of(arrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3, arrayOf(3, 3, 5, 5, 6, 7)),
            Arguments.of(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3, arrayOf(3, 4, 5, 6, 7, 8, 9, 10)),
            Arguments.of(arrayOf(1), 1, arrayOf(1)),
        )
    }
}