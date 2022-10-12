package problems.stringToInteger

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    8,
    "String to Integer (atoi)",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/string-to-integer-atoi/"
)
class Solution {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) return 0

        var sign = 1
        var base = 0
        var i = 0

        while (i < s.length && s[i] == ' ') i++
        if (i == s.length) return 0
        when (s[i]) {
            '-' -> {
                sign = -1
                i++
            }

            '+' -> i++
        }

        while (i < s.length && s[i] in '0'..'9') {
            if (base > Int.MAX_VALUE / 10 || (base == Int.MAX_VALUE / 10 && s[i] - '0' > 7)) {
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            base = base * 10 + (s[i++] - '0')
        }

        return sign * base
    }
}