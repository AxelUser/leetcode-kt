package solutions.editDistance

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(72, "Edit Distance", ProblemDifficulty.HARD,
    "https://leetcode.com/problems/edit-distance/")
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val tab = Array(m + 1) { IntArray(n + 1) }

        for (i in 1 .. m) {
            tab[i][0] = i
        }

        for (j in 1 .. n) {
            tab[0][j] = j
        }

        for (i in 1 .. m) {
            for (j in 1 .. n) {
                val replacementCost = if (word1[i - 1] == word2[j - 1]) 0 else 1

                tab[i][j] = minOf(
                    tab[i][j - 1] + 1,                  // insertion
                    tab[i - 1][j] + 1,                  // deletion
                    tab[i - 1][j - 1] + replacementCost // replace
                )
            }
        }

        return tab[m][n]
    }
}