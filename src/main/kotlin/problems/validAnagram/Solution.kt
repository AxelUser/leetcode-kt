package problems.validAnagram

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(242, "Valid Anagram", ProblemDifficulty.EASY, "https://leetcode.com/problems/valid-anagram/")
object Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val counts = IntArray(26)
        for (c in s) {
            counts[c - 'a']++
        }
        for (c in t) {
            counts[c - 'a']--
        }

        for (c in counts) {
            if (c != 0) return false
        }
        return true
    }
}