package problems.minimumPathSum

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(64, "Minimum Path Sum", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/minimum-path-sum/")
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val sums = grid.map { IntArray(it.size) { Int.MAX_VALUE } }
        sums[0][0] = grid[0][0]
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (y > 0) {
                    sums[y][x] = minOf(sums[y][x], sums[y - 1][x] + grid[y][x])
                }

                if (x > 0) {
                    sums[y][x] = minOf(sums[y][x], sums[y][x - 1] + grid[y][x])
                }
            }
        }

        return sums.last().last()
    }
}