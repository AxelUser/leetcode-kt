package solutions.removeElement

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(27, "Remove Element", ProblemDifficulty.EASY, "https://leetcode.com/problems/remove-element/")
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var start = 0
        for (n in nums) {
            if (n != `val`) nums[start++] = n
        }

        return start
    }
}