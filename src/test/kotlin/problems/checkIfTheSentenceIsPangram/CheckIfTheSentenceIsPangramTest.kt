package problems.checkIfTheSentenceIsPangram

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CheckIfTheSentenceIsPangramTest {

    @ParameterizedTest
    @MethodSource("args")
    fun checkIfPangram(sentence: String, expected: Boolean) {
        val actual = Solution.checkIfPangram(sentence)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("thequickbrownfoxjumpsoverthelazydog", true),
            Arguments.of("leetcode", false),
        )
    }
}