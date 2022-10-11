package problems.partitionArrayForMaximumSum

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(1043, "Partition Array for Maximum Sum", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/partition-array-for-maximum-sum/")
class Solution {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val dp = IntArray(arr.size)

        for (i in arr.indices) {
            var max = 0
            for (kSize in 1..k) {
                val j = i - kSize + 1
                if (j < 0) break

                max = maxOf(max, arr[j])
                dp[i] = maxOf(dp[i], (if (i < kSize) 0 else dp[i - kSize]) + max * kSize)
            }
        }

        return dp.last()
    }
}