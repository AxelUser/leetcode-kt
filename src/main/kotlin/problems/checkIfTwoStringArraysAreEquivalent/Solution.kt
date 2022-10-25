package problems.checkIfTwoStringArraysAreEquivalent

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1662,
    "Check If Two String Arrays are Equivalent",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/"
)
object Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var wIdx1 = 0
        var wIdx2 = 0
        var cIdx1 = 0
        var cIdx2 = 0

        while (wIdx1 < word1.size && wIdx2 < word2.size) {
            if (word1[wIdx1][cIdx1] != word2[wIdx2][cIdx2]) return false

            cIdx1 = (cIdx1 + 1) % word1[wIdx1].length
            if (cIdx1 == 0) wIdx1++

            cIdx2 = (cIdx2 + 1) % word2[wIdx2].length
            if (cIdx2 == 0) wIdx2++
        }

        return (wIdx1 == word1.size) && (wIdx2 == word2.size)
    }
}