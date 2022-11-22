package problems.binarySearch

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(704, "Binary Search", ProblemDifficulty.EASY, "https://leetcode.com/problems/binary-search/")
object Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            if (target < nums[mid]) right = mid - 1
            else left = mid + 1
        }

        return if (nums[left] == target) left else -1
    }
}