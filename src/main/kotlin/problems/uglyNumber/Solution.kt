package problems.uglyNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(263, "Ugly Number", ProblemDifficulty.EASY, "https://leetcode.com/problems/ugly-number/")
object Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) return false
        var res = n
        while (res % 2 == 0) {
            res /= 2
        }
        while (res % 3 == 0) {
            res /= 3
        }
        while (res % 5 == 0) {
            res /= 5
        }

        return res == 1
    }
}