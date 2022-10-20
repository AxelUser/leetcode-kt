package problems.numberOfProvinces

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    547,
    "Number of Provinces",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/number-of-provinces/"
)
object Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        if (isConnected.size == 1) return 1
        var count = 0
        for (i in isConnected.indices) {
            if (isConnected[i][i] != -1) {
                count++
                isConnected[i][i] = -1
                dfs(isConnected, i)
            }
        }

        return count
    }

    private fun dfs(isConnected: Array<IntArray>, i: Int) {
        for (j in isConnected.indices) {
            if (i != j && isConnected[j][j] != -1 && isConnected[i][j] == 1) {
                isConnected[j][j] = -1
                dfs(isConnected, j)
            }
        }
    }
}