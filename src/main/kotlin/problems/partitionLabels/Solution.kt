package problems.partitionLabels

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(763, "Partition Labels", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/partition-labels/")
class Solution {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26)
        for (i in s.indices) {
            last[s[i] - 'a'] = i
        }

        val res = mutableListOf<Int>()
        var start = 0
        var end = 0
        for (i in s.indices) {
            end = maxOf(end, last[s[i] - 'a'])
            if (end == i) {
                res.add(end - start + 1)
                start = i + 1
            }
        }

        return res
    }
}