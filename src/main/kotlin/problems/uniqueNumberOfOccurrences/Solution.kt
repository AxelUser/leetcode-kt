package problems.uniqueNumberOfOccurrences

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1207,
    "Unique Number of Occurrences",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/unique-number-of-occurrences/"
)
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val counts = mutableMapOf<Int, Int>()
        for (n in arr) {
            counts.compute(n) { _, v -> if (v == null) 1 else v + 1 }
        }

        val uniqueCounts = mutableSetOf<Int>()
        for (c in counts.values) {
            if (!uniqueCounts.add(c)) return false
        }

        return true
    }
}