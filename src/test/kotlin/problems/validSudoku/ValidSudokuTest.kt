package problems.validSudoku

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.parseSudoku

internal class ValidSudokuTest {

    @ParameterizedTest
    @MethodSource
    fun isValidSudoku(board: Array<CharArray>, expected: Boolean) {
        val actual = Solution.isValidSudoku(board)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isValidSudoku() = listOf(
            Arguments.of(
                parseSudoku(
                    """
                    [["5","3",".",".","7",".",".",".","."]
                    ,["6",".",".","1","9","5",".",".","."]
                    ,[".","9","8",".",".",".",".","6","."]
                    ,["8",".",".",".","6",".",".",".","3"]
                    ,["4",".",".","8",".","3",".",".","1"]
                    ,["7",".",".",".","2",".",".",".","6"]
                    ,[".","6",".",".",".",".","2","8","."]
                    ,[".",".",".","4","1","9",".",".","5"]
                    ,[".",".",".",".","8",".",".","7","9"]]
                """.trimIndent()
                ), true
            ),
            Arguments.of(
                parseSudoku(
                    """
                    [["8","3",".",".","7",".",".",".","."]
                    ,["6",".",".","1","9","5",".",".","."]
                    ,[".","9","8",".",".",".",".","6","."]
                    ,["8",".",".",".","6",".",".",".","3"]
                    ,["4",".",".","8",".","3",".",".","1"]
                    ,["7",".",".",".","2",".",".",".","6"]
                    ,[".","6",".",".",".",".","2","8","."]
                    ,[".",".",".","4","1","9",".",".","5"]
                    ,[".",".",".",".","8",".",".","7","9"]]
                """.trimIndent()
                ), false
            )
        )
    }
}