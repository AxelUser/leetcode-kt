package problems.firstMissingPositive

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    41,
    "First Missing Positive",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/first-missing-positive/"
)
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size

        for (i in nums.indices) {
            while (nums[i] in 1..n && nums[nums[i] - 1] != nums[i]) {
                nums.swap(i, nums[i] - 1)
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }

        return n + 1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[i] xor this[j]
        this[j] = this[j] xor this[i]
        this[i] = this[i] xor this[j]
    }
}