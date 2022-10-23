package problems.setMismatch

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class SetMismatchTest {

    @ParameterizedTest
    @MethodSource
    fun findErrorNums(nums: Array<Int>, expected: Array<Int>) {
        val actual = Solution.findErrorNums(nums.toIntArray())
        assertContentEquals(expected.toIntArray(), actual)
    }

    companion object {
        @JvmStatic
        fun findErrorNums() = listOf(
            Arguments.of(arrayOf(1, 2, 2), arrayOf(2, 3)),
            Arguments.of(arrayOf(1, 2, 2, 4), arrayOf(2, 3)),
            Arguments.of(arrayOf(1, 1), arrayOf(1, 2)),
        )
    }
}