package problems.stringCompression2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class StringCompression2Test {

    @ParameterizedTest
    @MethodSource
    fun getLengthOfOptimalCompression(s: String, k: Int, expected: Int) {
        val actual = Solution.getLengthOfOptimalCompression(s, k)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun getLengthOfOptimalCompression() = listOf(
            Arguments.of("aaabcccd", 2, 4),
            Arguments.of("aabbaa", 2, 2),
            Arguments.of("aaaaaaaaaaa", 0, 3),
            Arguments.of("a", 1, 0),
        )
    }
}