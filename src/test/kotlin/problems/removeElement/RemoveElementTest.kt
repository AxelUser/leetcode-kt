package problems.removeElement

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class RemoveElementTest {

    @ParameterizedTest
    @MethodSource
    fun removeElement(nums: IntArray, `val`: Int, expected: List<Int>) {
        val actual = Solution().removeElement(nums, `val`)
        assertContentEquals(expected, nums.take(actual))
    }

    companion object {
        @JvmStatic
        fun removeElement() = listOf(
            Arguments.of(arrayOf(3,2,2,3).toIntArray(), 3, listOf(2, 2)),
            Arguments.of(arrayOf(0,1,2,2,3,0,4,2).toIntArray(), 2, listOf(0,1,3,0,4)),
        )
    }
}