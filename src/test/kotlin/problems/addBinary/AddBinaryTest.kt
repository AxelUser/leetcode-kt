package problems.addBinary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddBinaryTest {

    @ParameterizedTest
    @MethodSource("args")
    fun addBinary(a: String, b: String, expected: String) {
        val actual = Solution().addBinary(a, b)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("11", "1", "100"),
            Arguments.of("1010", "1011", "10101")
        )
    }
}