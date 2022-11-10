package problems.removeAllAdjacentDuplicatesInString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveAllAdjacentDuplicatesInStringTest {

    @ParameterizedTest
    @MethodSource
    fun removeDuplicates(s: String, expected: String) {
        val actual = Solution.removeDuplicates(s)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun removeDuplicates() = listOf(
            Arguments.of("abbaca", "ca"),
            Arguments.of("azxxzy", "ay"),
            Arguments.of("baaaab", ""),
            Arguments.of("baaaaab", "bab"),
        )
    }
}