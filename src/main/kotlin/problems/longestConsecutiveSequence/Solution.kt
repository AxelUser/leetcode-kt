package problems.longestConsecutiveSequence

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    128,
    "Longest Consecutive Sequence",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/longest-consecutive-sequence/"
)
object Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()

        var longestSeq = 0
        for (n in set) {
            if (!set.contains(n - 1)) {
                var curSeq = 1
                var curNum = n
                while (set.contains(curNum + 1)) {
                    curNum++
                    curSeq++
                }

                longestSeq = maxOf(longestSeq, curSeq)
            }
        }

        return longestSeq
    }
}