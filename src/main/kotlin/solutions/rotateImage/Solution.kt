package solutions.rotateImage

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(48, "Rotate Image", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/rotate-image/")
class Solution {
    fun rotate(matrix: Array<IntArray>) {
        matrix.transpose()
        matrix.reflect()
    }

    private fun Array<IntArray>.transpose() {
        val n = this.size
        for (i in 0 until n) {
            for (j in i until n) {
                val temp = this[i][j]
                this[i][j] = this[j][i]
                this[j][i] = temp
            }
        }
    }

    private fun Array<IntArray>.reflect() {
        val n = this.size
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                val temp = this[i][j]
                this[i][j] = this[i][n - j - 1]
                this[i][n - j - 1] = temp
            }
        }
    }
}