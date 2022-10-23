package problems.setMismatch

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import kotlin.math.abs

@ProblemSolution(645, "Set Mismatch", ProblemDifficulty.EASY, "https://leetcode.com/problems/set-mismatch/")
object Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val ans = IntArray(2)
        for (i in nums.indices) {
            val absVal = abs(nums[i])
            ans[1] = ans[1] xor absVal xor (i + 1)
            // if value was already met
            if (nums[absVal - 1] < 0) {
                ans[0] = absVal
            } else {
                // mark value as visited
                nums[absVal - 1] = -nums[absVal - 1]
            }
        }

        ans[1] = ans[1] xor ans[0]

        return ans
    }
}