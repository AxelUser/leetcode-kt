package solutions.removeDuplicatesFromSortedArray2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    80,
    "Remove Duplicates from Sorted Array II",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/"
)
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        for (n in nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n
            }
        }

        return i
    }
}