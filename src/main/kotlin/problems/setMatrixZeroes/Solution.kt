package problems.setMatrixZeroes

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(73, "Set Matrix Zeroes", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/set-matrix-zeroes/")
object Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val zeroRows = HashSet<Int>()
        val zeroCols = HashSet<Int>()

        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                if (matrix[y][x] == 0) {
                    zeroRows.add(y)
                    zeroCols.add(x)
                }
            }
        }

        for (y in zeroRows) {
            for (x in matrix[y].indices) {
                matrix[y][x] = 0
            }
        }

        for (x in zeroCols) {
            for (y in matrix.indices) {
                matrix[y][x] = 0
            }
        }
    }
}