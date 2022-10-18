package problems.rotateArray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("args")
    fun rotate(nums: Array<Int>, k: Int, expected: Array<Int>) {
        val actual = nums.toIntArray()
        Solution.rotate(actual, k)
        assertContentEquals(expected.toIntArray(), actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 2, 3, 4, 5, 6, 7), 3, arrayOf(5, 6, 7, 1, 2, 3, 4)),
            Arguments.of(arrayOf(1, 2, 3, 4), 1, arrayOf(4, 1, 2, 3)),
            Arguments.of(arrayOf(1, 2), 0, arrayOf(1, 2)),
            Arguments.of(arrayOf(1, 2), 4, arrayOf(1, 2)),
            Arguments.of(arrayOf(-1, -100, 3, 99), 2, arrayOf(3, 99, -1, -100)),
        )
    }
}