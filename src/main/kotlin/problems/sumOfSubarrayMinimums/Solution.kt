package problems.sumOfSubarrayMinimums

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    907,
    "Sum of Subarray Minimums",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/sum-of-subarray-minimums/"
)
object Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val stack = Stack<Int>()
        var sum = 0L

        for (i in 0..arr.size) {
            while (!stack.empty() && (i == arr.size || arr[stack.peek()] >= arr[i])) {
                val mid = stack.pop()
                val left = if (stack.isEmpty()) -1 else stack.peek()
                val count = ((mid - left) * (i - mid)).toLong() % 1000000007
                sum += count * arr[mid] % 1000000007
            }
            stack.push(i)
        }
        return (sum % 1000000007).toInt()
    }
}