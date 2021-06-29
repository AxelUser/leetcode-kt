package solutions.longestCommonSubsequence

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(1143, "Longest Common Subsequence", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/longest-common-subsequence/")
class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n = text1.length
        val m = text2.length

        val tab = Array(2) { IntArray(m + 1) }

        var curRow = 0
        for (i in 1 .. n) {
            /* For each new row we will toggle between 0 an 1,
             * so that we will always write new length without overriding previous values
             */
            curRow = i and 1
            for (j in 1 .. m) {
                tab[curRow][j] = when {
                    text1[i - 1] == text2[j - 1] -> tab[1 - curRow][j - 1] + 1
                    else -> maxOf(tab[1 - curRow][j], tab[curRow][j - 1])
                }
            }
        }

        return tab[curRow][m]
    }
}