package problems.surroundedRegions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SurroundedRegionsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun solve(board: Array<CharArray>, expected: Array<CharArray>) {
        Solution().solve(board)
        assertEquals(expected.asString(), board.asString())
    }

    private fun Array<CharArray>.asString(): String = this.joinToString(prefix = "[", postfix = "]") {
        it.joinToString(
            prefix = "[",
            postfix = "]"
        )
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
            )
        )
    }
}