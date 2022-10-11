package problems.palindromeNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import kotlin.math.log10
import kotlin.math.pow

@ProblemSolution(9, "Palindrome Number", ProblemDifficulty.EASY, "https://leetcode.com/problems/palindrome-number/")
class Solution {
    fun isPalindrome(x: Int): Boolean {
        when {
            x < 0 -> return false
            x in 0..9 -> return true
            else -> {
                var r = x
                var digits = log10(x.toDouble()).toInt()
                while (digits >= 1) {
                    val first = (r / 10.0.pow(digits).toInt())
                    val last = r % 10
                    if(last != first) return false

                    r %= 10.0.pow(digits).toInt()
                    r /= 10

                    digits -= 2
                }

                return true
            }
        }

    }
}