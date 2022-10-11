package problems.countAndSay

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountAndSayTest {

    @ParameterizedTest
    @MethodSource("args")
    fun countAndSay(n: Int, expected: String) {
        val actual = Solution().countAndSay(n)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(1, "1"),
            Arguments.of(2, "11"),
            Arguments.of(3, "21"),
            Arguments.of(4, "1211"),
            Arguments.of(5, "111221"),
            Arguments.of(6, "312211"),
            Arguments.of(7, "13112221"),
            Arguments.of(8, "1113213211"),
            Arguments.of(9, "31131211131221"),
            Arguments.of(10, "13211311123113112211"),
        )
    }
}