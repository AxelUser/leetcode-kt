package problems.largestNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LargestNumberTest {

    @ParameterizedTest
    @MethodSource
    fun largestNumber(nums: Array<Int>, expected: String) {
        val actual = Solution.largestNumber(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun largestNumber() = listOf(
            Arguments.of(arrayOf(10, 2), "210"),
            Arguments.of(arrayOf(3, 30, 34, 5, 9), "9534330"),
            Arguments.of(arrayOf(0, 0), "0"),
        )
    }
}