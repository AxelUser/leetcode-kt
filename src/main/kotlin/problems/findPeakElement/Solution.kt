package problems.findPeakElement

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(162, "Find Peak Element", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/find-peak-element/")
object Solution {
    fun findPeakElement(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1

        while (low < high) {
            val pivot = low + (high - low) / 2
            if (pivot + 1 > high || nums[pivot] < nums[pivot + 1]) {
                low = pivot + 1
            } else {
                high = pivot
            }
        }

        return low
    }
}