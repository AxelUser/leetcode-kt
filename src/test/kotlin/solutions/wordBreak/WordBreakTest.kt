package solutions.wordBreak

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordBreakTest {

    @ParameterizedTest
    @MethodSource("args")
    fun wordBreak(s: String, wordDict: List<String>, expected: Boolean) {
        val actual = Solution().wordBreak(s, wordDict)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("leetcode", listOf("leet","code"), true),
            Arguments.of("applepenapple", listOf("apple","pen"), true),
            Arguments.of("catsandog", listOf("cats","dog","sand","and","cat"), false)
        )
    }
}