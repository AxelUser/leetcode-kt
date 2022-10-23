package problems.hammingDistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HammingDistanceTest {

    @ParameterizedTest
    @MethodSource
    fun hammingDistance(x: Int, y: Int, expected: Int) {
        val actual = Solution.hammingDistance(x, y)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun hammingDistance() = listOf(
            Arguments.of(1, 4, 2),
            Arguments.of(3, 1, 1),
        )
    }
}