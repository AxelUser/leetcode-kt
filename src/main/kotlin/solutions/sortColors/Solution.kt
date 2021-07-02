package solutions.sortColors

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(75, "Sort Colors", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/sort-colors/")
class Solution {
    fun sortColors(nums: IntArray) {
        var zeroIdx = 0
        var twoIdx = nums.lastIndex
        var idx = 0

        while (idx <= twoIdx && zeroIdx < twoIdx) {
            when(nums[idx]) {
                0 -> {
                    nums[idx] = nums[zeroIdx]
                    nums[zeroIdx] = 0
                    idx++
                    zeroIdx++
                }
                2 -> {
                    nums[idx] = nums[twoIdx]
                    nums[twoIdx] = 2
                    twoIdx--
                }
                else -> idx++
            }
        }
    }
}