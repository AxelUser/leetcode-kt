package problems.longestCommonPrefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestCommonPrefixTest {

    @ParameterizedTest
    @MethodSource
    fun longestCommonPrefix(strs: Array<String>, expected: String) {
        assertEquals(expected, Solution().longestCommonPrefix(strs))
    }

    companion object {
        @JvmStatic
        fun longestCommonPrefix() = listOf(
            Arguments.of(arrayOf("flower","flow","flight"), "fl"),
            Arguments.of(arrayOf("dog","racecar","car"), ""),
            Arguments.of(arrayOf("cir","car"), "c"),
        )
    }
}