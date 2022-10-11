package problems.generateParentheses

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(22, "Generate Parentheses", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/generate-parentheses/")
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val results = mutableListOf<String>()
        dfs("", 0, 0, n, results)
        return results
    }

    private fun dfs(s: String, openCount: Int, closeCount: Int, n: Int, results: MutableList<String>) {
        if (closeCount == n) {
            results.add(s)
            return
        }

        if (closeCount < openCount) dfs("$s)", openCount, closeCount + 1, n, results)

        if (openCount < n) dfs("$s(", openCount + 1, closeCount, n, results)
    }
}