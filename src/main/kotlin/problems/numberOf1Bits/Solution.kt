package problems.numberOf1Bits

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(191, "Number of 1 Bits", ProblemDifficulty.EASY, "https://leetcode.com/problems/number-of-1-bits/")
object Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var shifted = n

        while (shifted != 0) {
            if (shifted and 1 == 1) count++
            shifted = shifted ushr 1
        }

        return count
    }
}