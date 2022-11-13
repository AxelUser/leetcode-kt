package problems.reverseWordsInString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    151,
    "Reverse Words in a String",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/reverse-words-in-a-string/"
)
object Solution {
    fun reverseWords(s: String): String {
        var start = s.lastIndex
        var end = start
        return buildString {
            while (true) {
                while (end >= 0 && s[end] == ' ') end--

                if (end < 0) break

                start = end - 1
                while (start >= 0 && s[start] != ' ') start--

                if (isNotEmpty()) append(" ")

                append(s.substring(start + 1, end + 1))
                end = start
            }
        }
    }
}