package problems.mergeIntervals

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(56, "Merge Intervals", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/merge-intervals/")
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { arr1, arr2 -> arr1[0].compareTo(arr2[0]) }
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