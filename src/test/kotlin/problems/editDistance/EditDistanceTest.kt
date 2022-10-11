package problems.editDistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class EditDistanceTest {

    @ParameterizedTest
    @MethodSource
    fun minDistance(word1: String, word2: String, expected: Int) {
        assertEquals(expected, Solution().minDistance(word1, word2))
    }

    companion object {
        @JvmStatic
        fun minDistance() = listOf(
            Arguments.of("horse", "ros", 3),
            Arguments.of("intention", "execution", 5),
        )
    }
}