package problems.partitionLabels

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class PartitionLabelsTest {

    @ParameterizedTest
    @MethodSource
    fun partitionLabels(s: String, expected: List<Int>) {
        val actual = Solution().partitionLabels(s)
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun partitionLabels() = listOf(
            Arguments.of("ababcbacadefegdehijhklij", listOf(9, 7, 8)),
            Arguments.of("eccbbbbdec", listOf(10)),
            Arguments.of("abcdef", listOf(1, 1, 1, 1, 1, 1)),
        )
    }
}