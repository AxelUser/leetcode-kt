package problems.searchInRotatedSortedArray2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    81,
    "Search in Rotated Sorted Array II",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"
)
class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var lo = 0
        var hi = nums.lastIndex

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] == target) return true

            // target may be in both segments, binary search will not help here, so we move forward
            if (nums[lo] == nums[mid]) {
                lo++
                continue
            }

            // true if in first, false if in second
            val targetSegment = nums[lo] <= target
            val midSegment = nums[lo] <= nums[mid]

            // if in different segments
            if (targetSegment xor midSegment) {
                // if mid is in first segment, then target is in second
                if (midSegment) {
                    lo = mid + 1
                } else {
                    // else mid is in second and target is in first
                    hi = mid - 1
                }
            } else {
                // else they are in same segment
                if (target < nums[mid]) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            }
        }

        return false
    }
}