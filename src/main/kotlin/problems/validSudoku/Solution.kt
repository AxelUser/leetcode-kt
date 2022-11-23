package problems.validSudoku

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(36, "Valid Sudoku", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/valid-sudoku/")
object Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSets = Array(9) { mutableSetOf<Char>() }
        val colSets = Array(9) { mutableSetOf<Char>() }
        val boxSets = Array(3) { Array(3) { mutableSetOf<Char>() } }

        for (row in board.indices) {
            for (col in board[row].indices) {
                board[row][col].takeIf { it != '.' }?.apply {
                    if (!rowSets[row].add(this) ||
                        !colSets[col].add(this) ||
                        !boxSets[row / 3][col / 3].add(this)
                    ) {
                        return false
                    }
                }
            }
        }

        return true
    }
}