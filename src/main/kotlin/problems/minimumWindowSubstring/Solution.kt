package problems.minimumWindowSubstring

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    76,
    "Minimum Window Substring",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/minimum-window-substring/"
)
object Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""

        val tMap = t.groupingBy { it }.eachCount()
        var minLen = s.length + 1
        var minStart = -1
        val window = mutableMapOf<Char, Int>()
        var start = 0
        var end = 0

        var matched = 0

        while (start < s.length && end < s.length) {
            // collecting matching elements
            while (matched != t.length && end < s.length) {
                val cur = s[end]
                val curCount = window.compute(cur) { _, count -> if (count == null) 1 else count + 1 }!!
                val targetCount = tMap[cur]
                if (targetCount != null) {
                    if (curCount <= targetCount) {
                        matched++
                    }
                }
                end++
            }

            // if reached end and did not collect all elements - break
            if (matched != t.length) break

            var curLen = end - start

            // decreasing start
            while (true) {
                if (curLen < minLen) {
                    minLen = curLen
                    minStart = start
                }

                val removed = s[start]
                start++
                curLen--
                val targetCount = tMap[removed] ?: continue
                val windowCount =
                    window.computeIfPresent(removed) { _, count -> if (count - 1 == 0) null else count - 1 }

                // if now window does not contain all target elements - break decreasing loop
                if (windowCount == null || windowCount < targetCount) {
                    matched--
                    break
                }
            }
        }

        return if (minStart >= 0) s.substring(minStart, minStart + minLen) else ""
    }
}