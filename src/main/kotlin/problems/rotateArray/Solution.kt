package problems.rotateArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(189, "Rotate Array", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/rotate-array/")
object Solution {
    fun rotate(nums: IntArray, k: Int) {
        val trunk = k % nums.size
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, trunk - 1)
        reverse(nums, trunk, nums.size - 1)
    }

    private fun reverse(nums: IntArray, low: Int, high: Int) {
        var l = low
        var h = high
        while (l < h) {
            nums[l] = nums[l] xor nums[h]
            nums[h] = nums[h] xor nums[l]
            nums[l] = nums[l] xor nums[h]
            l++
            h--
        }
    }
}