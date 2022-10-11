package problems.maxSubArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import kotlin.math.max

@ProblemSolution(53, "Maximum Subarray", ProblemDifficulty.EASY, "https://leetcode.com/problems/maximum-subarray/")
class Solution {
    // Kadane’s Algorithm
    fun maxSubArray(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        var maxSum = nums[0]
        var sum = nums[0]

        for (i in 1 until nums.size) {
            sum = max(sum + nums[i], nums[i])
            maxSum = max(maxSum, sum)
        }

        return maxSum
    }
}