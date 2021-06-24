package solutions.searchInRotatedSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(33, "Search in Rotated Sorted Array", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/search-in-rotated-sorted-array/")
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1

        return binarySearch(nums, target, 0, nums.size - 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, l: Int, r: Int): Int {
        if(l > r) return -1

        val mid = (l + r) / 2
        if (nums[mid] == target) return mid

        if (nums[l] <= nums[mid]) {
            if(target >= nums[l] && target < nums[mid]) {
                return binarySearch(nums, target, l, mid - 1)
            }

            return binarySearch(nums, target, mid + 1, r)
        }

        if (target > nums[mid] && target <= nums[r]) {
            return binarySearch(nums, target, mid + 1, r)
        }

        return binarySearch(nums, target, l, mid - 1)
    }
}