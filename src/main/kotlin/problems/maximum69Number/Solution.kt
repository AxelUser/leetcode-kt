package problems.maximum69Number

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import kotlin.math.pow

@ProblemSolution(1323, "Maximum 69 Number", ProblemDifficulty.EASY, "https://leetcode.com/problems/maximum-69-number/")
object Solution {
    fun maximum69Number(num: Int): Int {
        var lastSix = -1
        var i = 0
        var cur = num
        while (cur != 0) {
            if (cur % 10 == 6) {
                lastSix = i
            }
            cur /= 10
            i++
        }

        return if (lastSix != -1) num + 3 * 10.0.pow(lastSix).toInt() else num
    }
}