package problems.removeAllAdjacentDuplicatesInString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    1047,
    "v",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/"
)
object Solution {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        return buildString {
            for (c in stack) append(c)
        }
    }
}