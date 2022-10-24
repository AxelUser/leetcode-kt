package problems.singleNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SingleNumberTest {

    @ParameterizedTest
    @MethodSource
    fun singleNumber(nums: Array<Int>, expected: Int) {
        val actual = Solution.singleNumber(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun singleNumber() = listOf(
            Arguments.of(arrayOf(2, 2, 1), 1),
            Arguments.of(arrayOf(4, 1, 2, 1, 2), 4),
            Arguments.of(arrayOf(1), 1),
            Arguments.of(arrayOf(4, 2, 4), 2),
        )
    }
}