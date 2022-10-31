package problems.toeplitzMatrix

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(766, "Toeplitz Matrix", ProblemDifficulty.EASY, "https://leetcode.com/problems/toeplitz-matrix/")
object Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.size == 1) return true
        for (row in 0 until matrix.size - 1) {
            for (col in 0 until matrix[row].size - 1) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false
                }
            }
        }

        return true
    }
}