package twoSum

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for ((idx, value) in nums.withIndex()) {
            map[value] = idx
        }

        for ((idx, value) in nums.withIndex()) {
            val complementIdx = map[target - value]
            if (complementIdx != null && idx != complementIdx) {
                return arrayOf(idx, complementIdx).toIntArray()
            }
        }

        return IntArray(0)
    }
}