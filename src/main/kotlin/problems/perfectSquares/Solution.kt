package problems.perfectSquares

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(279, "Perfect Squares", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/perfect-squares/")
object Solution {
    fun numSquares(n: Int): Int {
        val tab = IntArray(n + 1) { n }
        tab[0] = 0
        for (target in 1..n) {
            for (num in 1..target) {
                val sqr = num * num
                if (target - sqr < 0) break
                tab[target] = minOf(tab[target], tab[target - sqr] + 1)
            }
        }

        return tab[n]
    }
}