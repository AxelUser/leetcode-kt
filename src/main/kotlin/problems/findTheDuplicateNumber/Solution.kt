package problems.findTheDuplicateNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    287,
    "Find the Duplicate Number",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/find-the-duplicate-number/"
)
object Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }
}