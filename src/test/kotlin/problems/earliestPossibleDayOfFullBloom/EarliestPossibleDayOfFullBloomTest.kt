package problems.earliestPossibleDayOfFullBloom

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class EarliestPossibleDayOfFullBloomTest {

    @ParameterizedTest
    @MethodSource
    fun earliestFullBloom(plantTime: Array<Int>, growTime: Array<Int>, expected: Int) {
        val actual = Solution.earliestFullBloom(plantTime.toIntArray(), growTime.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun earliestFullBloom() = listOf(
            Arguments.of(arrayOf(1, 4, 3), arrayOf(2, 3, 1), 9),
            Arguments.of(arrayOf(1, 2, 3, 2), arrayOf(2, 1, 2, 1), 9),
            Arguments.of(arrayOf(1), arrayOf(1), 2),
        )
    }
}