package solutions.houseRobber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(198, "House Robber", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/house-robber/")
class Solution {
    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size + 1)
        memo[1] = nums[0]
        for (i in 1 until nums.size) {
            memo[i + 1] = maxOf(memo[i - 1] + nums[i], memo[i])
        }

        return memo.last()
    }
}