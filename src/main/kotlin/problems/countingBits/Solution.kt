package problems.countingBits

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(338, "Counting Bits", ProblemDifficulty.EASY, "https://leetcode.com/problems/counting-bits/")
class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray(n + 1)
        for(i in 0 .. n) {
            res[i] = res[i shr 1] + (i and 1)
        }
        return res
    }
}