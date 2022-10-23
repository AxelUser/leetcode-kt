package problems.findTheDifference

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    389,
    "Find the Difference",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/find-the-difference/"
)
object Solution {
    fun findTheDifference(s: String, t: String): Char {
        var res = 0

        for (i in s.indices) {
            res = res xor s[i].toInt() xor t[i].toInt()
        }

        return (res xor t.last().toInt()).toChar()
    }
}