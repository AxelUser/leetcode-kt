package problems.singleNumber3

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class SingleNumber3Test {

    @ParameterizedTest
    @MethodSource
    fun singleNumber(nums: Array<Int>, expected: Array<Int>) {
        val actual = Solution.singleNumber(nums.toIntArray()).toTypedArray()
        assertContentEquals(expected.sortedArray(), actual.sortedArray())
    }

    companion object {
        @JvmStatic
        fun singleNumber() = listOf(
            Arguments.of(arrayOf(1, 2, 1, 3, 2, 5), arrayOf(3, 5)),
            Arguments.of(arrayOf(-1, 0), arrayOf(-1, 0)),
            Arguments.of(arrayOf(0, 1), arrayOf(0, 1)),
        )
    }
}