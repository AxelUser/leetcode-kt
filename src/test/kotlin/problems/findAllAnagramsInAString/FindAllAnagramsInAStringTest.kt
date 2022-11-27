package problems.findAllAnagramsInAString

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class FindAllAnagramsInAStringTest {

    @ParameterizedTest
    @MethodSource
    fun findAnagrams(s: String, p: String, expected: List<Int>) {
        val actual = Solution().findAnagrams(s, p)
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findAnagrams() = listOf(
            Arguments.of("cbaebabacd", "abc", listOf(0, 6)),
            Arguments.of("abab", "ab", listOf(0, 1, 2)),
            Arguments.of("baa", "aa", listOf(1)),
        )
    }
}