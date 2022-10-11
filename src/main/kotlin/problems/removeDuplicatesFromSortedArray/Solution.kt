package problems.removeDuplicatesFromSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(26, "Remove Duplicates from Sorted Array", ProblemDifficulty.EASY,
    "https://leetcode.com/problems/remove-duplicates-from-sorted-array/")
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size < 2) return nums.size

        var uniqueCount = 1

        for (i in 1 until nums.size) {
            val check = nums[uniqueCount - 1]
            if (check != nums[i]) {
                nums[uniqueCount++] = nums[i]
            }
        }

        return uniqueCount
    }
}