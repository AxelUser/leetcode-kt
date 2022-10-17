package problems.findTheDuplicateNumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindTheDuplicateNumberTest {

    @ParameterizedTest
    @MethodSource("args")
    fun findDuplicate(input: Array<Int>, expected: Int) {
        val actual = Solution.findDuplicate(input.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 3, 4, 2, 2), 2),
            Arguments.of(arrayOf(3, 1, 3, 4, 2), 3),
            Arguments.of(arrayOf(1, 1), 1),
        )
    }
}