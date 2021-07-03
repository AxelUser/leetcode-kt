package solutions.searchInsertPosition

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(35, "Search Insert Position", ProblemDifficulty.EASY, "https://leetcode.com/problems/search-insert-position/")
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        var insert = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                target > nums[mid] -> {
                    left = mid + 1
                    insert = mid + 1
                }
                target < nums[mid] -> {
                    right = mid - 1
                    insert = mid
                }
            }
        }

        return insert
    }
}