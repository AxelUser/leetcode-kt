package problems.continuousSubarraySum

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    523,
    "Continuous Subarray Sum",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/continuous-subarray-sum/"
)
object Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val remMap = mutableMapOf(0 to 0)
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (remMap.computeIfAbsent(sum % k) { i + 1 } < i) return true
        }

        return false
    }
}