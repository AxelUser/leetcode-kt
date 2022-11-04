package problems.reverseVowelsOfAString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    345,
    "Reverse Vowels of a String",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/reverse-vowels-of-a-string/"
)
object Solution {
    private fun Char.isVowel(): Boolean = when (this) {
        'a' -> true
        'e' -> true
        'i' -> true
        'o' -> true
        'u' -> true
        'A' -> true
        'E' -> true
        'I' -> true
        'O' -> true
        'U' -> true
        else -> false
    }

    fun reverseVowels(s: String): String {
        val result = s.toCharArray()
        var left = 0
        var foundLeft = false
        var right = s.lastIndex

        while (left < right) {
            if (!foundLeft && !s[left].isVowel()) {
                left++
                continue
            } else {
                foundLeft = true
            }

            if (!s[right].isVowel()) {
                right--
                continue
            }

            result[left] = s[right]
            result[right] = s[left]
            left++
            right--
            foundLeft = false
        }

        return String(result)
    }
}