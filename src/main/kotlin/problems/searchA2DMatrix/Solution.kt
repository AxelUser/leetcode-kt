package problems.searchA2DMatrix

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    74,
    "Search a 2D Matrix",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/search-a-2d-matrix/"
)
object Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val arrSize = matrix[0].size
        var low = 0
        var high = matrix.size * arrSize - 1
        while (low <= high) {
            // 0 1 2
            // 3 4 5
            val pivot = low + (high - low) / 2
            val elem = matrix[pivot / arrSize][pivot % arrSize]
            if (elem == target) return true

            if (target < elem) {
                high = pivot - 1
            } else {
                low = pivot + 1
            }
        }

        return false
    }
}