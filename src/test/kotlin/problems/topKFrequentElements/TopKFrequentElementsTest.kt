package problems.topKFrequentElements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class TopKFrequentElementsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun topKFrequent(input: Array<Int>, k: Int, expected: Array<Int>) {
        val actual = Solution.topKFrequent(input.toIntArray(), k)
        assertContentEquals(expected.toIntArray().sortedArray(), actual.sortedArray())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 1, 1, 2, 2, 3), 2, arrayOf(1, 2)),
            Arguments.of(arrayOf(1), 1, arrayOf(1)),
        )
    }
}