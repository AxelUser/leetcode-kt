package solutions.basicCalculator

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.Stack

@ProblemSolution(224, "Basic Calculator", ProblemDifficulty.HARD, "https://leetcode.com/problems/basic-calculator/")
class Solution {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var result = 0
        var sign = 1
        var i = 0

        while(i < s.length) {
            when(s[i]) {
                in '0' .. '9' -> {
                    var number = s[i] - '0'
                    while (i + 1 < s.length && s[i + 1].isDigit()) {
                        number = number * 10 + (s[++i] - '0')
                    }
                    result += number * sign
                }
                '+' -> sign = 1
                '-' -> sign = -1
                '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    result = 0
                    sign = 1
                }
                ')' -> {
                    val prevSign = stack.pop()
                    val prevResult = stack.pop()
                    result = prevResult + prevSign * result
                }
            }
            i++
        }

        return result
    }
}