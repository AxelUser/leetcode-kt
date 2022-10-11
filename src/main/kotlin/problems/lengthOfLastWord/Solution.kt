package problems.lengthOfLastWord

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(58, "Length of Last Word", ProblemDifficulty.EASY, "https://leetcode.com/problems/length-of-last-word/")
class Solution {
    fun lengthOfLastWord(s: String): Int {
        var l = 0

        for (i in s.indices) {
            if (s[i] != ' ') {
                l = if (i > 0 && s[i - 1] == ' ') 1 else l + 1
            }
        }

        return l
    }
}