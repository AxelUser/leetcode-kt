package solutions.longestIncreasingSubsequence

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(300, "Longest Increasing Subsequence", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/longest-increasing-subsequence/")
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val seq = mutableListOf<Int>()
        seq.add(nums[0])

        for (n in nums.drop(1)) {
            if (n > seq.last()) {
                seq.add(n)
            } else {
                val swapIdx = binarySearch(seq, n)
                seq[swapIdx] = n
            }
        }

        return seq.size
    }

    private fun binarySearch(nums: List<Int>, n: Int): Int {
        var low = 0
        var high = nums.lastIndex

        while (low < high) {
            val mid = low + (high - low) / 2

            if (nums[mid] == n) {
                return mid
            } else if (n > nums[mid]) {
                low = mid + 1
            } else {
                high = mid
            }
        }

        return low
    }
}