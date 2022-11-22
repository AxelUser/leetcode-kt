package problems.mergeIntervals

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(56, "Merge Intervals", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/merge-intervals/")
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val merged = mutableListOf<IntArray>()

        for (interval in intervals) {
            if(merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }

        return merged.toTypedArray()
    }
}