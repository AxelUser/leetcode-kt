package problems.findTheTownJudge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindTheTownJudgeTest {

    @ParameterizedTest
    @MethodSource
    fun findJudge(n: Int, trust: Array<Array<Int>>, expected: Int) {
        val actual = Solution.findJudge(n, trust.map { it.toIntArray() }.toTypedArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findJudge() = listOf(
            Arguments.of(2, arrayOf(arrayOf(1, 2)), 2),
            Arguments.of(3, arrayOf(arrayOf(1, 3), arrayOf(2, 3)), 3),
            Arguments.of(3, arrayOf(arrayOf(1, 3), arrayOf(2, 3), arrayOf(3, 1)), -1),
        )
    }
}