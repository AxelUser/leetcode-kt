package problems.removeInvalidParentheses

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    301,
    "Remove Invalid Parentheses",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/remove-invalid-parentheses/"
)
class Solution {
    private val ans = mutableSetOf<String>()

    fun removeInvalidParentheses(s: String): List<String> {
        var delLeft = 0
        var delRight = 0
        for (c in s) {
            when (c) {
                '(' -> delLeft++
                ')' -> {
                    if (delLeft > 0) {
                        delLeft--
                    } else {
                        delRight++
                    }
                }
            }
        }

        dfs(s, StringBuilder(s.length), 0, 0, 0, delLeft, delRight)
        return ans.toList()
    }

    private fun dfs(s: String, build: StringBuilder, cur: Int, left: Int, right: Int, delLeft: Int, delRight: Int) {
        if (cur == s.length) {
            if (delLeft == 0 && delRight == 0) {
                ans.add(build.toString())
            }
        } else {
            val curC = s[cur]

            if ((curC == '(' && delLeft > 0) || (curC == ')' && delRight > 0)) {
                dfs(
                    s,
                    build,
                    cur + 1,
                    left,
                    right,
                    delLeft - if (curC == '(') 1 else 0,
                    delRight - if (curC == ')') 1 else 0
                )
            }

            build.append(curC)

            when (curC) {
                '(' -> dfs(s, build, cur + 1, left + 1, right, delLeft, delRight)
                ')' -> if (right < left) {
                    dfs(s, build, cur + 1, left, right + 1, delLeft, delRight)
                }

                else -> dfs(s, build, cur + 1, left, right, delLeft, delRight)
            }

            build.deleteCharAt(build.lastIndex)
        }
    }
}