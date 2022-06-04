package solutions.uniquePaths

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(62, "Unique Paths", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/unique-paths/")
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val t = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                t[i][j] = if (i == 0 || j == 0) 1 else t[i - 1][j] + t[i][j - 1]
            }
        }

        return t.last().last()
    }
}