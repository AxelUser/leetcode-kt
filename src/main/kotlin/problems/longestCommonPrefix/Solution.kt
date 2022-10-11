package problems.longestCommonPrefix

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(14, "Longest Common Prefix", ProblemDifficulty.EASY,
    "https://leetcode.com/problems/longest-common-prefix/")
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()) return ""

        val n = strs.minOf { it.length }
        var common = 0

        for (i in 0 until n) {
            val c = strs[0][i]
            if(strs.any { it[i] != c }) break

            common++
        }

        return if (common == 0) "" else strs[0].substring(0, common)
    }
}