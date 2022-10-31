package problems.singleNumber2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SingleNumber2Test {

    @ParameterizedTest
    @MethodSource
    fun singleNumber(nums: Array<Int>, expected: Int) {
        val actual = Solution.singleNumber(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun singleNumber() = listOf(
            Arguments.of(arrayOf(1, 1, 1, 2), 2),
            Arguments.of(arrayOf(0, 1, 0, 1, 0, 1, 99), 99),
            Arguments.of(arrayOf(2, 2, 3, 2), 3),
        )
    }
}