package problems.singleNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(136, "Single Number", ProblemDifficulty.EASY, "https://leetcode.com/problems/single-number/")
object Solution {
    fun singleNumber(nums: IntArray): Int {
        var mask = 0

        for (n in nums) {
            mask = mask xor n
        }

        return mask
    }
}