package problems.jumpGame2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(45, "Jump Game II", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/jump-game-ii/")
class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var curJumpReachable = 0
        var farthest = 0

        for (i in 0 until nums.size - 1) {
            farthest = maxOf(farthest, i + nums[i])
            if (farthest >= nums.size - 1) return jumps + 1

            if (curJumpReachable == i) {
                jumps++
                curJumpReachable = farthest
            }
        }

        return jumps
    }
}