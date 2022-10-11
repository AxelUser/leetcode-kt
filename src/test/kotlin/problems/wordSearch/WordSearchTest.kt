package problems.wordSearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WordSearchTest {

    @ParameterizedTest
    @MethodSource("args")
    fun exist(board: Array<CharArray>, word: String, expected: Boolean) {
        val actual = Solution().exist(board, word)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf("ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()), "ABCCED", true),
            Arguments.of(arrayOf("ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()), "SEE", true),
            Arguments.of(arrayOf("ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()), "ABCB", false)
        )
    }
}