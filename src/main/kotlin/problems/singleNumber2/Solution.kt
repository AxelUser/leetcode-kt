package problems.singleNumber2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(137, "Single Number II", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/single-number-ii/")
object Solution {
    fun singleNumber(nums: IntArray): Int {
        var s1 = 0
        var s2 = 0
        for (n in nums) {
            s1 = s1 xor n and s2.inv()
            s2 = s2 xor n and s1.inv()
        }

        return s1
    }
}