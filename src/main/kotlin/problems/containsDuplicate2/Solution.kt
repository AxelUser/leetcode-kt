package problems.containsDuplicate2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    219,
    "Contains Duplicate II",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/contains-duplicate-ii/"
)
object Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.size == 1 || k == 0) return false
        val window = mutableMapOf<Int, Int>()
        var start = 0
        var end = 0
        while (end <= k && end < nums.size) {
            if (window.contains(nums[end])) return true
            window[nums[end++]] = 1
        }

        while (end < nums.size) {
            window.computeIfPresent(nums[start++]) { _, v -> if (v - 1 == 0) null else v - 1 }
            if (window.compute(nums[end++]) { _, v -> if (v == null) 1 else null } == null) return true
        }

        return false
    }
}