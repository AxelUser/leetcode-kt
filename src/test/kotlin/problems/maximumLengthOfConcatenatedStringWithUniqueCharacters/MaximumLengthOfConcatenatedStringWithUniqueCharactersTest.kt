package problems.maximumLengthOfConcatenatedStringWithUniqueCharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumLengthOfConcatenatedStringWithUniqueCharactersTest {

    @ParameterizedTest
    @MethodSource
    fun maxLength(arr: List<String>, expected: Int) {
        val actual = Solution.maxLength(arr)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun maxLength() = listOf(
            Arguments.of(listOf("un", "iq", "ue"), 4),
            Arguments.of(listOf("cha", "r", "act", "ers"), 6),
            Arguments.of(listOf("abcdefghijklmnopqrstuvwxyz"), 26),
        )
    }
}