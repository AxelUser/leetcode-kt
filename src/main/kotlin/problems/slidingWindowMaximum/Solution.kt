package problems.slidingWindowMaximum

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    239,
    "Sliding Window Maximum",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/sliding-window-maximum/"
)
object Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)
        val deq = ArrayDeque<Int>()

        for (i in nums.indices) {
            if (deq.isNotEmpty() && deq.first == i - k) {
                deq.removeFirst()
            }

            while (deq.isNotEmpty() && nums[deq.last] <= nums[i]) {
                deq.removeLast()
            }

            deq.addLast(i)

            if (i >= k - 1) {
                res[i - k + 1] = nums[deq.first]
            }
        }

        return res
    }
}