package problems.singleNumber3

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(260, "Single Number III", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/single-number-iii/")
object Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var cmb = 0
        for (n in nums) {
            cmb = cmb xor n
        }
        cmb = cmb and -cmb

        val res = IntArray(2)
        for (n in nums) {
            if ((cmb and n) == 0) {
                res[0] = res[0] xor n
            } else {
                res[1] = res[1] xor n
            }
        }

        return res
    }
}