package problems.editDistance

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(72, "Edit Distance", ProblemDifficulty.HARD,
    "https://leetcode.com/problems/edit-distance/")
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val tab = Array(2) { IntArray(n + 1) { it } }

        var curRow = 0
        for (i in 1 .. m) {
            curRow = i and 1
            tab[curRow][0] = i
            for (j in 1 .. n) {
                val replacementCost = if (word1[i - 1] == word2[j - 1]) 0 else 1

                tab[curRow][j] = minOf(
                    tab[curRow][j - 1] + 1,                  // insertion
                    tab[1 - curRow][j] + 1,                  // deletion
                    tab[1 - curRow][j - 1] + replacementCost // replace
                )
            }
        }

        return tab[curRow][n]
    }
}