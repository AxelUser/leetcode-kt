package problems.makeTheStringGreat

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*
import kotlin.math.abs

@ProblemSolution(
    1544,
    "Make The String Great",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/make-the-string-great/"
)
object Solution {
    fun makeGood(s: String): String {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.isNotEmpty() && abs(stack.peek() - c) == 32) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        return buildString(stack.size) {
            for (c in stack) append(c)
        }
    }
}