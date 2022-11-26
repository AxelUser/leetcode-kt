package problems.sum4

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(18, "4Sum", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/4sum/")
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return kSum(nums, target.toLong(), 0, 4)
    }

    private fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<MutableList<Int>> {
        val res = mutableListOf<MutableList<Int>>()

        if (start == nums.size) return res

        val avg = target / k

        if (nums[start] > avg || avg > nums[nums.lastIndex]) return res

        if (k == 2) return twoSum(nums, target, start)

        for (i in start..nums.lastIndex) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (subset in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(subset.apply { add(nums[i]) })
                }
            }
        }

        return res
    }

    private fun twoSum(nums: IntArray, target: Long, start: Int): MutableList<MutableList<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        val s = mutableSetOf<Long>()

        for (i in start..nums.lastIndex) {
            if (res.isEmpty() || res[res.lastIndex][1] != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(mutableListOf(target.toInt() - nums[i], nums[i]))
                }
            }
            s.add(nums[i].toLong())
        }

        return res
    }
}