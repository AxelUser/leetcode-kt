package problems.shortestCommonSupersequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ShortestCommonSupersequenceTest {

    @ParameterizedTest
    @MethodSource
    fun shortestCommonSupersequence(str1: String, str2: String, expected: String) {
        assertEquals(expected, Solution().shortestCommonSupersequence(str1, str2))
    }

    companion object {
        @JvmStatic
        fun shortestCommonSupersequence() = listOf(
            Arguments.of("abac", "cab", "cabac")
        )
    }
}