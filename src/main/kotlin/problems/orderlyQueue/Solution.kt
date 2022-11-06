package problems.orderlyQueue

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(899, "Orderly Queue", ProblemDifficulty.HARD, "https://leetcode.com/problems/orderly-queue/")
object Solution {
    fun orderlyQueue(s: String, k: Int): String {
        return if (k == 1) {
            var ans = s
            for (i in s.indices) {
                (s.substring(i) + s.substring(0, i)).takeIf { it < ans }?.apply { ans = this }
            }
            ans
        } else {
            String(s.toCharArray().apply { sort() })
        }
    }
}