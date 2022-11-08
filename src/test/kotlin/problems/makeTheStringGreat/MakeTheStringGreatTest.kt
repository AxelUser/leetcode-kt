package problems.makeTheStringGreat

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MakeTheStringGreatTest {

    @ParameterizedTest
    @MethodSource
    fun makeGood(s: String, expected: String) {
        val actual = Solution.makeGood(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun makeGood() = listOf(
            Arguments.of("leEeetcode", "leetcode"),
            Arguments.of("abBAcC", ""),
        )
    }
}