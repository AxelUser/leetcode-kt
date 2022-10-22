package problems.minimumWindowSubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumWindowSubstringTest {

    @ParameterizedTest
    @MethodSource
    fun minWindow(s: String, t: String, expected: String) {
        val actual = Solution.minWindow(s, t)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun minWindow() = listOf(
            Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
            Arguments.of("a", "a", "a"),
            Arguments.of("a", "aa", ""),
            Arguments.of("bac", "aa", ""),
            Arguments.of("bAc", "abc", ""),
            Arguments.of("ab", "a", "a"),
        )
    }
}