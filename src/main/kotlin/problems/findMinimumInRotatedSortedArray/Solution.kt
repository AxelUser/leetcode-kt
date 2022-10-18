package problems.findMinimumInRotatedSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    153,
    "Find Minimum in Rotated Sorted Array",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/"
)
object Solution {
    fun findMin(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            if (nums[low] < nums[high]) break

            val pivot = low + (high - low) / 2
            if (nums[pivot] >= nums[low]) {
                low = pivot + 1
            } else {
                high = pivot
            }
        }

        return nums[low]
    }
}