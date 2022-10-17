package problems.checkIfTheSentenceIsPangram

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1832,
    "Check if the Sentence Is Pangram",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/check-if-the-sentence-is-pangram/"
)
object Solution {
    fun checkIfPangram(sentence: String): Boolean {
        var map = 0b0000_0000_0000_0000_0000_0000_0000
        val msk = 0b0011_1111_1111_1111_1111_1111_1111
        for (c in sentence) {
            map = map or (1 shl (c - 'a'))
            if (map == msk) return true
        }
        return false
    }
}