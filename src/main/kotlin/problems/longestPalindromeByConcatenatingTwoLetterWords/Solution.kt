package problems.longestPalindromeByConcatenatingTwoLetterWords

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    2131,
    "Longest Palindrome by Concatenating Two Letter Words",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/"
)
object Solution {
    fun longestPalindrome(words: Array<String>): Int {
        val latinCount = 26
        val m = Array(latinCount) { IntArray(latinCount) }
        var charIndex = 0
        for (w in words) {
            val w1 = w[0] - 'a'
            val w2 = w[1] - 'a'
            m[w1][w2]++
            charIndex = charIndex or (w1 * 5) or (w2 * 5)
        }

        var count = 0
        var hasCentral = false
        for (i in 0 until latinCount) {
            if (charIndex and (i * 5) != i * 5) {
                continue
            }
            count += if (m[i][i] % 2 == 0) {
                m[i][i]
            } else {
                hasCentral = true
                m[i][i] - 1
            }

            for (j in i + 1 until latinCount) {
                if (charIndex and (j * 5) != j * 5) continue
                count += 2 * minOf(m[i][j], m[j][i])
            }
        }

        if (hasCentral) {
            count++
        }

        return 2 * count
    }
}