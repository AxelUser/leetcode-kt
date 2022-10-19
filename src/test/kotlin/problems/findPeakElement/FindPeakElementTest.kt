package problems.findPeakElement

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindPeakElementTest {

    @ParameterizedTest
    @MethodSource
    fun findPeakElement(nums: Array<Int>, expected: Set<Int>) {
        val actual = Solution.findPeakElement(nums.toIntArray())
        assert(expected.contains(actual))
    }

    companion object {
        @JvmStatic
        fun findPeakElement() = listOf(
            Arguments.of(arrayOf(1, 2, 3, 1), setOf(2)),
            Arguments.of(arrayOf(1, 2, 1, 3, 5, 6, 4), setOf(1, 5)),
            Arguments.of(arrayOf(1), setOf(0))
        )
    }
}