package problems.whereWillTheBallFall

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1706,
    "Where Will the Ball Fall",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/where-will-the-ball-fall/"
)
object Solution {
    fun findBall(grid: Array<IntArray>): IntArray {
        val res = IntArray(grid[0].size)
        for (i in res.indices) {
            res[i] = dfs(grid, i)
        }

        return res
    }

    private fun dfs(grid: Array<IntArray>, colStart: Int): Int {
        var row = 0
        var col = colStart
        while (row < grid.size) {
            val dir = grid[row][col]
            col += dir
            if (col in 0 until grid[0].size && dir == grid[row][col]) {
                row++
            } else return -1
        }

        return col
    }
}