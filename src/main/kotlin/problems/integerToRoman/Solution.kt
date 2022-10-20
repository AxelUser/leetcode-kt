package problems.integerToRoman

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(12, "Integer to Roman", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/integer-to-roman/")
object Solution {
    fun intToRoman(num: Int): String {
        val thousands = arrayOf("", "M", "MM", "MMM")
        val hundreds = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val tens = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val digits = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + digits[num % 10]
    }
}