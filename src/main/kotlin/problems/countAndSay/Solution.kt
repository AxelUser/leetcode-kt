package problems.countAndSay

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(38, "Count and Say", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/count-and-say/")
class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"

        val say = countAndSay(n - 1)

        return buildString {
            var count = 0
            var counting: Char? = null
            for (c in say) {
                if (c == counting || counting == null) {
                    counting = c
                    count++
                } else {
                    append(count).append(counting)
                    counting = c
                    count = 1
                }
            }
            append(count).append(counting)
        }
    }
}