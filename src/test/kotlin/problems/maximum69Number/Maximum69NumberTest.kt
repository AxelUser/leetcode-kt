package problems.maximum69Number

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Maximum69NumberTest {

    @ParameterizedTest
    @MethodSource
    fun maximum69Number(num: Int, expected: Int) {
        val actual = Solution.maximum69Number(num)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun maximum69Number() = listOf(
            Arguments.of(9669, 9969),
            Arguments.of(9996, 9999),
            Arguments.of(9999, 9999),
        )
    }
}