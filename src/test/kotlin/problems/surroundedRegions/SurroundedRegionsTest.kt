package problems.surroundedRegions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.stringifyMatrix

internal class SurroundedRegionsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun solve(board: Array<CharArray>, expected: Array<CharArray>) {
        Solution().solve(board)
        assertEquals(expected.stringifyMatrix(), board.stringifyMatrix())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                arrayOf(
                    "XXXX".toCharArray(),
                    "XOOX".toCharArray(),
                    "XXOX".toCharArray(),
                    "XOXX".toCharArray()
                ), arrayOf(
                    "XXXX".toCharArray(),
                    "XXXX".toCharArray(),
                    "XXXX".toCharArray(),
                    "XOXX".toCharArray()
                )
            ),
            Arguments.of(
                arrayOf(
                    "XOXOXO".toCharArray(),
                    "OXOXOX".toCharArray(),
                    "XOXOXO".toCharArray(),
                    "OXOXOX".toCharArray()
                ), arrayOf(
                    "XOXOXO".toCharArray(),
                    "OXXXXX".toCharArray(),
                    "XXXXXO".toCharArray(),
                    "OXOXOX".toCharArray()
                )
            ),
        )
    }
}