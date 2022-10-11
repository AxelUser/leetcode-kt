package problems.findTheIndexOfTheFirstOccurrenceInString

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindTheIndexOfTheFirstOccurrenceInStringTest {

    @ParameterizedTest
    @MethodSource("args")
    fun strStr(haystack: String, needle: String, expected: Int) {
        val actual = Solution().strStr(haystack, needle)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("sadbutsad", "sad", 0),
            Arguments.of("leetcode", "leeto", -1),
            Arguments.of("zipzag", "ag", 4),
            Arguments.of("mississippi", "issip", 4),
        )
    }
}