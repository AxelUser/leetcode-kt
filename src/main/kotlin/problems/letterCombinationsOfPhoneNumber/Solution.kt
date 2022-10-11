package problems.letterCombinationsOfPhoneNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(17, "Letter Combinations of a Phone Number", ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/letter-combinations-of-a-phone-number/")
class Solution {
    private val letters = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        return dfs(digits, "", 0)
    }

    private fun dfs(digits: String, prefix: String, idx: Int): List<String> {
        if(idx >= digits.length) return listOf(prefix)

        val res = mutableListOf<String>()
        for (l in letters[digits[idx]]!!) {
            res.addAll(dfs(digits, prefix + l, idx + 1))
        }

        return res
    }
}