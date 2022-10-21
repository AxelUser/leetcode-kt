package problems.moveZeroes

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(283, "Move Zeroes", ProblemDifficulty.EASY, "https://leetcode.com/problems/move-zeroes/")
object Solution {
    fun moveZeroes(nums: IntArray) {
        var slow = 0
        nums.forEachIndexed { fast, num ->
            if (num != 0) {
                nums[fast] = 0
                nums[slow] = num
                slow++
            }
        }
    }
}