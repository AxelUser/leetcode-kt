package solutions.plusOne

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(66, "Plus One", ProblemDifficulty.EASY, "https://leetcode.com/problems/plus-one/")
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if(digits.last() < 9) {
            digits[digits.lastIndex] += 1
            return digits
        }

        var carry = 1
        val res = MutableList(digits.size) {0}

        for (i in digits.lastIndex downTo 0) {
            val sum = carry + digits[i]
            carry = sum / 10
            res[i] = sum % 10
        }

        if (carry > 0) res.add(0, carry)
        return res.toIntArray()
    }
}