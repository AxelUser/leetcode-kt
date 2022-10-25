package problems.checkIfTwoStringArraysAreEquivalent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CheckIfTwoStringArraysAreEquivalentTest {

    @ParameterizedTest
    @MethodSource
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>, expected: Boolean) {
        val actual = Solution.arrayStringsAreEqual(word1, word2)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun arrayStringsAreEqual() = listOf(
            Arguments.of(arrayOf("ab", "c"), arrayOf("a", "bc"), true),
            Arguments.of(arrayOf("a", "bc"), arrayOf("ab", "c"), true),
            Arguments.of(arrayOf("a", "cb"), arrayOf("ab", "c"), false),
            Arguments.of(arrayOf("abc", "d", "defg"), arrayOf("abcddefg"), true),
            Arguments.of(arrayOf("a", "cb"), arrayOf("ab", "cd"), false),
        )
    }
}