package problems.spiralMatrix

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(54, "Spiral Matrix", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/spiral-matrix/")
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var dir = 0

        var yS = 0
        var yE = matrix.size - 1
        var xS = 0
        var xE = matrix[0].size - 1
        val res = mutableListOf<Int>()

        while (yS <= yE && xS <= xE) {
            when (dir) {
                // right
                0 -> {
                    for (x in xS..xE) {
                        res.add(matrix[yS][x])
                    }
                    yS++
                }
                // down
                1 -> {
                    for (y in yS..yE) {
                        res.add(matrix[y][xE])
                    }
                    xE--
                }
                // left
                2 -> {
                    for (x in xE downTo xS) {
                        res.add(matrix[yE][x])
                    }
                    yE--
                }
                // up
                3 -> {
                    for (y in yE downTo yS) {
                        res.add(matrix[y][xS])
                    }
                    xS++
                }
            }
            dir = (dir + 1) % 4
        }

        return res
    }
}