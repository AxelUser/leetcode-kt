package problems.findFirstAndLastPositionOfElementInSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(34, "Find First and Last Position of Element in Sorted Array", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/")
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return IntArray(2) { -1 }

        val first = binarySearchFirst(nums, target)
        if(first == -1) return IntArray(2) { -1 }

        return arrayOf(
            first,
            binarySearchLast(nums, target)
        ).toIntArray()
    }

    private fun binarySearchFirst(nums: IntArray, target: Int): Int{
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (target < nums[mid]) {
                end = mid - 1
            } else if (target > nums[mid]) {
                start = mid + 1
            } else if ((mid == 0 || target > nums[mid - 1]) && target == nums[mid]) {
                return mid
            } else {
                end = mid - 1
            }
        }

        return -1
    }

    private fun binarySearchLast(nums: IntArray, target: Int): Int{
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (target < nums[mid]) {
                end = mid - 1
            } else if (target > nums[mid]) {
                start = mid + 1
            } else if ((mid == nums.lastIndex || target < nums[mid + 1]) && target == nums[mid]) {
                return mid
            } else {
                start = mid + 1
            }
        }

        return -1
    }
}