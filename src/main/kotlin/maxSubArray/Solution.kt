package maxSubArray

import kotlin.math.max

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