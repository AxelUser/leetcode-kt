package problems.validAnagram

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidAnagramTest {

    @ParameterizedTest
    @MethodSource
    fun isAnagram(s: String, t: String, expected: Boolean) {
        val actual = Solution.isAnagram(s, t)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isAnagram() = listOf(
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("rat", "car", false),
        )
    }
}