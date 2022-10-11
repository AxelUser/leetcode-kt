package problems.permutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PermutationsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun permute(nums: IntArray, expected: List<List<Int>>) {
        val actual = Solution().permute(nums)

        val assertableResult = actual.map { it.joinToString() }.toSet()
        assertEquals(actual.size, assertableResult.size)

        assertEquals(expected.map { it.joinToString() }.toSet(), assertableResult)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                arrayOf(1, 2, 3).toIntArray(),
                listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1)
                )
            ),
            Arguments.of(arrayOf(0, 1).toIntArray(), listOf(listOf(0, 1), listOf(1, 0))),
            Arguments.of(arrayOf(1).toIntArray(), listOf(listOf(1))),
        )
    }
}