package problems.shortestCommonSupersequence

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(1092, "Shortest Common Supersequence", ProblemDifficulty.HARD,
    "https://leetcode.com/problems/shortest-common-supersequence/")
class Solution {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        return shortestCommonSupersequenceLength(str1, str2)
            .shortestCommonSupersequence(str1, str2, str1.length, str2.length)
    }

    private fun shortestCommonSupersequenceLength(str1: String, str2: String): Array<IntArray> {
        val tab = Array(str1.length + 1) { IntArray(str2.length + 1) }

        for (i in 0 .. str1.length) {
            tab[i][0] = i
        }

        for (j in 0 .. str2.length) {
            tab[0][j] = j
        }

        for (i in 1 .. str1.length) {
            for (j in 1 .. str2.length) {
                tab[i][j] = when {
                    str1[i - 1] == str2[j - 1] -> tab[i - 1][j - 1] + 1
                    else -> minOf(tab[i - 1][j] + 1, tab[i][j - 1] + 1)
                }
            }
        }

        return tab
    }

    private fun Array<IntArray>.shortestCommonSupersequence(str1: String, str2: String, m: Int, n: Int): String {
        if (m == 0) return str2.substring(0, n)
        if (n == 0) return str1.substring(0, m)

        return if (str1[m - 1] == str2[n - 1]) {
            shortestCommonSupersequence(str1, str2, m - 1, n - 1) + str1[m - 1]
        } else {
            if (this[m - 1][n] < this[m][n - 1]) {
                shortestCommonSupersequence(str1, str2, m - 1, n) + str1[m - 1]
            } else {
                shortestCommonSupersequence(str1, str2, m, n - 1) + str2[n - 1]
            }
        }
    }
}