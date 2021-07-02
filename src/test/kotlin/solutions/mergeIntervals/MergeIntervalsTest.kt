package solutions.mergeIntervals

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class MergeIntervalsTest {

    @ParameterizedTest
    @MethodSource
    fun merge(intervals: Array<IntArray>, expected: Array<IntArray>) {
        val actual = Solution().merge(intervals)
        for (i in expected.indices) {
            assertContentEquals(expected[i], actual[i])
        }
    }

    companion object {
        @JvmStatic
        fun merge() = listOf(
            Arguments.of(
                arrayOf(arrayOf(2,3).toIntArray(), arrayOf(1,6).toIntArray(), arrayOf(2,10).toIntArray(), arrayOf(15,18).toIntArray()),
                arrayOf(arrayOf(1,10).toIntArray(), arrayOf(15,18).toIntArray()),
            ),
            Arguments.of(
                arrayOf(arrayOf(1,3).toIntArray(), arrayOf(2,6).toIntArray(), arrayOf(8,10).toIntArray(), arrayOf(15,18).toIntArray()),
                arrayOf(arrayOf(1,6).toIntArray(), arrayOf(8,10).toIntArray(), arrayOf(15,18).toIntArray()),
            ),
            Arguments.of(
                arrayOf(arrayOf(1,4).toIntArray(), arrayOf(4,5).toIntArray()),
                arrayOf(arrayOf(1,5).toIntArray()),
            ),
        )
    }
}