package problems.majorityElement

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(169, "Majority Element", ProblemDifficulty.EASY, "https://leetcode.com/problems/majority-element/")
object Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 1
        var majEl = nums[0]
        for (i in 1 until nums.size) {
            if (count == 0) {
                majEl = nums[i]
            }

            count += if (nums[i] == majEl) 1 else -1
        }

        return majEl
    }
}