package problems.longestRepeatingCharacterReplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestRepeatingCharacterReplacementTest {

    @ParameterizedTest
    @MethodSource
    fun characterReplacement(s: String, k: Int, expected: Int) {
        assertEquals(expected, Solution().characterReplacement(s, k))
    }

    companion object {
        @JvmStatic
        fun characterReplacement() = listOf(
            Arguments.of("ABAB", 2, 4),
            Arguments.of("AABABBA", 1, 4),
        )
    }
}