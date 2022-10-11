package problems.wordBreak

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(139, "Word Break", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/word-break/")
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val found = BooleanArray(s.length + 1)
        found[0] = true
        for (i in 1 .. s.length) {
            for (word in wordDict) {
                if (word.length <= i) {
                    if (found[i - word.length]) {
                        if (s.substring(i - word.length, i) == word) {
                            found[i] = true
                            break
                        }
                    }
                }
            }
        }

        return found.last()
    }
}