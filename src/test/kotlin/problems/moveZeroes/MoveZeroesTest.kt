package problems.moveZeroes

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource
    fun moveZeroes(nums: Array<Int>, expected: Array<Int>) {
        val actual = nums.toIntArray()
        Solution.moveZeroes(actual)
        assertContentEquals(expected.toIntArray(), actual)
    }

    companion object {
        @JvmStatic
        fun moveZeroes() = listOf(
            Arguments.of(arrayOf(0, 1, 0, 3, 12), arrayOf(1, 3, 12, 0, 0)),
            Arguments.of(arrayOf(0, 0, 0, 0, 1), arrayOf(1, 0, 0, 0, 0)),
            Arguments.of(arrayOf(0), arrayOf(0)),
            Arguments.of(arrayOf(1, 2), arrayOf(1, 2)),
        )
    }
}