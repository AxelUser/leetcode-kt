package problems.searchInRotatedSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    33, "Search in Rotated Sorted Array", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/search-in-rotated-sorted-array/"
)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.lastIndex, target)
    }

    private fun binarySearch(nums: IntArray, lo: Int, hi: Int, target: Int): Int {
        if (hi < lo) return -1

        val mid = lo + (hi - lo) / 2
        println(mid)

        if (target == nums[mid]) return mid

        // if left part is sorted
        if (nums[lo] <= nums[mid]) {
            // if target is in left
            if (target >= nums[lo] && target < nums[mid]) {
                return binarySearch(nums, lo, mid - 1, target)
            }
            // else search in right
            return binarySearch(nums, mid + 1, hi, target)
        }

        // left part is not sorted then

        // if target is in sorted right
        if (target > nums[mid] && target <= nums[hi]) {
            return binarySearch(nums, mid + 1, hi, target)
        }

        // else search in left
        return binarySearch(nums, lo, mid - 1, target)
    }
}