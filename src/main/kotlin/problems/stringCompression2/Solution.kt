package problems.stringCompression2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1531,
    "String Compression II",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/string-compression-ii/"
)
object Solution {
    private fun getCompressedLength(len: Int): Int {
        return if (len == 0) {
            0
        } else if (len == 1) {
            1
        } else if (len < 10) {
            2
        } else if (len < 100) {
            3
        } else 4
    }

    private fun solveTopDown(
        dp: Array<Array<Array<IntArray>>>,
        i: Int,
        prev: Int,
        seqLen: Int,
        k: Int,
        s: String
    ): Int {
        if (i == s.length) return getCompressedLength(seqLen)
        if (dp[i][prev][seqLen][k] == Int.MAX_VALUE) {
            val letter = s[i] - 'a'
            if (k > 0) dp[i][prev][seqLen][k] = solveTopDown(dp, i + 1, prev, seqLen, k - 1, s)
            dp[i][prev][seqLen][k] = if (letter == prev) {
                minOf(dp[i][prev][seqLen][k], solveTopDown(dp, i + 1, prev, seqLen + 1, k, s))
            } else {
                minOf(dp[i][prev][seqLen][k], solveTopDown(dp, i + 1, letter, 1, k, s) + getCompressedLength(seqLen))
            }
        }
        return dp[i][prev][seqLen][k]
    }

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val dp = Array(s.length) { Array(26) { Array(s.length + 1) { IntArray(k + 1) { Int.MAX_VALUE } } } }
        return solveTopDown(dp, 0, 0, 0, k, s)
    }
}