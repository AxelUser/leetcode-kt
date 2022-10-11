package problems.partitionArrayForMaximumSum

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class PartitionArrayForMaximumSumTest {

    @ParameterizedTest
    @MethodSource
    fun maxSumAfterPartitioning(arr: IntArray, k: Int, expected: Int) {
        assertEquals(expected, Solution().maxSumAfterPartitioning(arr, k))
    }

    companion object {
        @JvmStatic
        fun maxSumAfterPartitioning() = listOf(
            Arguments.of(arrayOf(1,15,7,9,2,5,10).toIntArray(), 3, 84),
            Arguments.of(arrayOf(1,4,1,5,7,3,6,1,9,9,3).toIntArray(), 4, 83),
            Arguments.of(arrayOf(1).toIntArray(), 1, 1),
        )
    }
}