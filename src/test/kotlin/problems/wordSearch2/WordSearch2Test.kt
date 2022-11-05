package problems.wordSearch2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class WordSearch2Test {

    @ParameterizedTest
    @MethodSource
    fun findWords(board: Array<Array<Char>>, words: Array<String>, expected: List<String>) {
        val actual = Solution.findWords(board.map { it.toCharArray() }.toTypedArray(), words)
        assertContentEquals(
            expected.sorted(),
            actual.sorted(),
            "expected: ${expected.sorted().joinToString()}, actual: ${actual.sorted().joinToString()}"
        )
    }

    companion object {
        @JvmStatic
        fun findWords() = listOf(
            Arguments.of(
                arrayOf(
                    arrayOf('o', 'a', 'a', 'n'),
                    arrayOf('e', 't', 'a', 'e'),
                    arrayOf('i', 'h', 'k', 'r'),
                    arrayOf('i', 'f', 'l', 'v'),
                ), arrayOf("oath", "pea", "eat", "rain"), listOf("eat", "oath")
            ),
            Arguments.of(
                arrayOf(
                    arrayOf('o', 'a', 'a', 'n'),
                    arrayOf('e', 't', 'a', 'e'),
                    arrayOf('i', 'h', 'k', 'r'),
                    arrayOf('i', 'f', 'l', 'v'),
                ), arrayOf("oath", "oat", "ihf", "ihfl"), listOf("oath", "oat", "ihf", "ihfl")
            ),
            Arguments.of(
                arrayOf(
                    arrayOf('o', 'a', 'b', 'n'),
                    arrayOf('o', 't', 'a', 'e'),
                    arrayOf('a', 'h', 'k', 'r'),
                    arrayOf('a', 'f', 'l', 'v')
                ), arrayOf("oa", "oaa"), listOf("oa", "oaa")
            ),
            Arguments.of(
                arrayOf(
                    arrayOf('o', 'a', 'a', 'n'),
                    arrayOf('e', 't', 'a', 'e'),
                    arrayOf('i', 'h', 'k', 'r'),
                    arrayOf('i', 'f', 'l', 'v')
                ), arrayOf("oath", "pea", "eat", "rain", "hklf", "hf"), listOf("oath", "eat", "hklf", "hf")
            )
        )
    }
}