package problems.decodeString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.lang.StringBuilder
import java.util.*

@ProblemSolution(394, "Decode String", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/decode-string/")
class Solution {
    fun decodeString(s: String): String {
        var idx = 0
        val counts = Stack<Int>()
        val strings = Stack<String>()
        var accumulated = ""

        while (idx < s.length) {
            when {
                s[idx].isDigit() -> {
                    var count = 0
                    while (s[idx].isDigit()) {
                        count = count * 10 + (s[idx++] - '0')
                    }
                    counts.push(count)
                }
                s[idx] == '[' -> {
                    strings.push(accumulated)
                    accumulated = ""
                    idx++
                }
                s[idx] == ']' -> {
                    val sb = StringBuilder(strings.pop())
                    val repeatCount = counts.pop()
                    for (r in 0 until repeatCount) {
                        sb.append(accumulated)
                    }
                    accumulated = sb.toString()
                    idx++
                }
                else -> {
                    accumulated += s[idx++]
                }
            }
        }

        return accumulated
    }
}