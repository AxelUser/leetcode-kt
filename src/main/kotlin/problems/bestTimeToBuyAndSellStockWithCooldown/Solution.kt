package problems.bestTimeToBuyAndSellStockWithCooldown

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    309,
    "Best Time to Buy and Sell Stock with Cooldown",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/"
)
object Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0

        var b0 = -prices[0]
        var b1 = b0
        var s0 = 0
        var s1 = 0
        var s2 = 0

        for (i in 1..prices.lastIndex) {
            b0 = maxOf(b1, s2 - prices[i])
            s0 = maxOf(s1, b1 + prices[i])
            b1 = b0
            s2 = s1
            s1 = s0
        }

        return s0
    }
}