package problems.breakAPalindrome

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1328,
    "Break a Palindrome",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/break-a-palindrome/"
)
object Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length == 1) return ""

        return buildString(palindrome.length) {
            var broken = false
            for (i in 0 until palindrome.length / 2) {
                val c = palindrome[i]
                if (!broken && c != 'a') {
                    broken = true
                    append("a")
                } else {
                    append(c)
                }
            }

            for (i in palindrome.length / 2 until palindrome.length - 1) {
                append(palindrome[i])
            }

            if (!broken) {
                append("b")
            } else {
                append(palindrome[palindrome.lastIndex])
            }
        }
    }
}