package problems.slidingWindowMedian

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    480,
    "Sliding Window Median",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/sliding-window-median/"
)
object Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val leftMaxHeap = PriorityQueue<Int>(Comparator { a, b -> b.compareTo(a) })
        val rightMinHeap = PriorityQueue<Int>()

        val res = DoubleArray(nums.size - k + 1)

        for (i in nums.indices) {
            if (i - k >= 0) {
                if (nums[i - k] <= leftMaxHeap.peek()) {
                    leftMaxHeap.remove(nums[i - k])
                } else {
                    rightMinHeap.remove(nums[i - k])
                }
            }

            if (leftMaxHeap.size == rightMinHeap.size) {
                if (rightMinHeap.isNotEmpty() && nums[i] > rightMinHeap.peek()) {
                    rightMinHeap.offer(nums[i])
                } else leftMaxHeap.offer(nums[i])
                // max left > min right
            } else if (leftMaxHeap.size > rightMinHeap.size) {
                if (nums[i] < leftMaxHeap.peek()) {
                    // left max element -> right min element
                    rightMinHeap.offer(leftMaxHeap.poll())
                    leftMaxHeap.offer(nums[i])
                } else {
                    rightMinHeap.offer(nums[i])
                }
                // max left < min right
            } else {
                if (nums[i] > rightMinHeap.peek()) {
                    // right min element -> left max element
                    leftMaxHeap.offer(rightMinHeap.poll())
                    rightMinHeap.offer(nums[i])
                } else {
                    leftMaxHeap.offer(nums[i])
                }
            }

            if (i >= k - 1) {
                res[i - k + 1] = if (k % 2 == 0) {
                    val left = leftMaxHeap.peek()
                    val right = rightMinHeap.peek()
                    (left / 2) + (right / 2) + (((left % 2) + (right % 2)) / 2.0)
                } else if (leftMaxHeap.size > rightMinHeap.size) {
                    leftMaxHeap.peek().toDouble()
                } else {
                    rightMinHeap.peek().toDouble()
                }
            }
        }

        return res
    }
}