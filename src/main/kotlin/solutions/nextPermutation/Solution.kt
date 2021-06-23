package solutions.nextPermutation

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(31, "Next Permutation", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/next-permutation/")
class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        var i = nums.size - 2

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }

        if (i >= 0) {
            var j = nums.size - 1
            while (nums[j] <= nums[i]) {
                j--
            }
            swapInPlace(nums, i, j)
        }

        reverseInPlace(nums, i + 1)
    }

    private fun swapInPlace(nums: IntArray, ai: Int, bi: Int) {
        val temp = nums[ai]
        nums[ai] = nums[bi]
        nums[bi] = temp
    }

    private fun reverseInPlace(nums: IntArray, start: Int) {
        var i = start
        var j = nums.size - 1

        while (i < j) {
            swapInPlace(nums, i, j)
            i++
            j--
        }
    }
}