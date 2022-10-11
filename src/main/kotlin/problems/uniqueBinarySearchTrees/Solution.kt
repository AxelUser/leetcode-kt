package problems.uniqueBinarySearchTrees

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(96, "Unique Binary Search Trees", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/unique-binary-search-trees/")
class Solution {
    fun numTrees(n: Int): Int {
        val catalan = IntArray(n + 2) { 1 }

        for (i in 2 .. n) {
            catalan[i] = 0
            for (j in 0 until i) {
                catalan[i] += catalan[j] * catalan[i - j - 1]
            }
        }

        return catalan[n]
    }
}