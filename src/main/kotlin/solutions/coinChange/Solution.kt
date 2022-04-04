package solutions.coinChange

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(322, "Coin Change", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/coin-change/")
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (coin in coins) {
            for (i in 0 .. amount) {
                if (i - coin >= 0) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}