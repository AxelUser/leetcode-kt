package problems.sortColors

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class SortColorsTest {

    @ParameterizedTest
    @MethodSource
    fun sortColors(nums: IntArray, expected: IntArray) {
        Solution().sortColors(nums)
        assertContentEquals(expected, nums)
    }

    companion object {
        @JvmStatic
        fun sortColors() = listOf(
            Arguments.of(arrayOf(2,0,2,1,1,0).toIntArray(), arrayOf(0,0,1,1,2,2).toIntArray()),
            Arguments.of(arrayOf(2,0,1).toIntArray(), arrayOf(0,1,2).toIntArray()),
            Arguments.of(arrayOf(0).toIntArray(), arrayOf(0).toIntArray()),
            Arguments.of(arrayOf(1).toIntArray(), arrayOf(1).toIntArray()),
        )
    }
}