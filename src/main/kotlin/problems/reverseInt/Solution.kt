package problems.reverseInt

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(7, "Reverse Integer", ProblemDifficulty.EASY, "https://leetcode.com/problems/reverse-integer/")
class Solution {
    fun reverse(x: Int): Int {
        var res = 0
        var n = x
        while (n != 0) {
            val dig = n % 10
            n /= 10

            when {
                res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && dig > 7) -> return 0
                res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && dig < -8) -> return 0
            }

            res = res * 10 + dig
        }

        return res
    }
}