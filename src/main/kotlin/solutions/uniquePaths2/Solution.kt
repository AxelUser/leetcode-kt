package solutions.uniquePaths2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(63, "Unique Paths II", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/unique-paths-ii/")
class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        for (i in obstacleGrid.indices) {
            for (j in obstacleGrid[i].indices) {
                obstacleGrid[i][j] = if (obstacleGrid[i][j] == 1) 0
                    else if (i == 0 && j == 0) 1
                    else if (i == 0) obstacleGrid[i][j - 1]
                    else if (j == 0) obstacleGrid[i - 1][j]
                    else obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
            }
        }

        return obstacleGrid.last().last()
    }
}