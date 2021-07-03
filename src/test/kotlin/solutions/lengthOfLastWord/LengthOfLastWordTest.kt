package solutions.lengthOfLastWord

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LengthOfLastWordTest {

    @ParameterizedTest
    @MethodSource
    fun lengthOfLastWord(s: String, expected: Int) {
        assertEquals(expected, Solution().lengthOfLastWord(s))
    }

    companion object {
        @JvmStatic
        fun lengthOfLastWord() = listOf(
            Arguments.of("Hello World", 5),
            Arguments.of(" ", 0),
            Arguments.of("I", 1),
            Arguments.of("I ", 1),
            Arguments.of(" I", 1),
        )
    }
}