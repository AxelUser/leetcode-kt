package solutions.climbingStairs

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(70, "Climbing Stairs", ProblemDifficulty.EASY, "https://leetcode.com/problems/climbing-stairs/")
class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1

        var first = 1
        var second = 2

        for (step in 3..n) {
            val third = first + second
            first = second
            second = third
        }

        return second
    }
}