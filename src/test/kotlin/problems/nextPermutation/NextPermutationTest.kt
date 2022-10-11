package problems.nextPermutation

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class NextPermutationTest {

    @ParameterizedTest
    @MethodSource
    fun nextPermutation(nums: IntArray, expected: IntArray) {
        Solution().nextPermutation(nums)
        assertContentEquals(expected, nums)
    }

    companion object {
        @JvmStatic
        fun nextPermutation() = listOf(
            Arguments.of(arrayOf(1,2,3).toIntArray(), arrayOf(1,3,2).toIntArray()),
            Arguments.of(arrayOf(3,2,1).toIntArray(), arrayOf(1,2,3).toIntArray()),
            Arguments.of(arrayOf(1,1,5).toIntArray(), arrayOf(1,5,1).toIntArray()),
            Arguments.of(arrayOf(1).toIntArray(), arrayOf(1).toIntArray()),
        )
    }
}