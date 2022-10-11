package problems.jumpGame

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(55, "Jump Game", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/jump-game/")
class Solution {
    fun canJump(nums: IntArray): Boolean {
        var reachable = 0
        for (i in nums.indices) {
            if (reachable < i) {
                return false
            }
            reachable = maxOf(reachable, i + nums[i])
        }

        return true
    }
}