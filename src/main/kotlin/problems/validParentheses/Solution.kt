package problems.validParentheses

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(20, "Valid Parentheses", ProblemDifficulty.EASY, "https://leetcode.com/problems/valid-parentheses/")
class Solution {
    fun isValid(s: String): Boolean {
        val parentheses = Stack<Char>()

        for (c in s) {
            when (c) {
                '(', '[', '{' -> parentheses.push(c)
                ')' -> {
                    if (parentheses.empty() || parentheses.pop() != '(') return false
                }
                ']' -> {
                    if (parentheses.empty() || parentheses.pop() != '[') return false
                }
                '}' -> {
                    if (parentheses.empty() || parentheses.pop() != '{') return false
                }
            }
        }

        return parentheses.empty()
    }
}