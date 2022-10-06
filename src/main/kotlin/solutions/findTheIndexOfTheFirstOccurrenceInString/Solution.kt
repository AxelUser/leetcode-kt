package solutions.findTheIndexOfTheFirstOccurrenceInString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    28,
    "Find the Index of the First Occurrence in a String",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/"
)
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        var startIdx = 0

        while (startIdx < haystack.length) {
            var nIdx = 0
            var hIdx = startIdx
            while (hIdx < haystack.length && nIdx < needle.length && haystack[hIdx] == needle[nIdx]) {
                if (++nIdx == needle.length) return startIdx
                hIdx++
            }
            startIdx++
        }

        return -1
    }
}