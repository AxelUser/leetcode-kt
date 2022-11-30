package problems.uniqueNumberOfOccurrences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueNumberOfOccurrencesTest {

    @ParameterizedTest
    @MethodSource
    fun uniqueOccurrences(arr: IntArray, expected: Boolean) {
        assertEquals(expected, Solution().uniqueOccurrences(arr))
    }

    companion object {
        @JvmStatic
        fun uniqueOccurrences() = listOf(
            Arguments.of(intArrayOf(1, 2, 2, 1, 1, 3), true),
            Arguments.of(intArrayOf(1, 2), false),
            Arguments.of(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0), true),
        )
    }
}