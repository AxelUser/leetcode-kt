package problems.sum4

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class Sum4Test {

    @ParameterizedTest
    @MethodSource
    fun fourSum(nums: IntArray, target: Int, expected: List<List<Int>>) {
        val actual = Solution().fourSum(nums, target)
        assertContentEquals(
            expected.map { it.sorted().joinToString() }.sorted(),
            actual.map { it.sorted().joinToString() }.sorted(),
        )
    }

    companion object {
        @JvmStatic
        fun fourSum() = listOf(
            //Arguments.of(intArrayOf(1,0,-1,0,-2,2), 0, listOf(listOf(-2,-1,1,2), listOf(-2,0,0,2), listOf(-1,0,0,1))),
            //Arguments.of(intArrayOf(2,2,2,2,2), 8, listOf(listOf(2,2,2,2))),
            Arguments.of(intArrayOf(2, 7, 9, 3), 10, emptyList<List<Int>>()),
        )
    }
}