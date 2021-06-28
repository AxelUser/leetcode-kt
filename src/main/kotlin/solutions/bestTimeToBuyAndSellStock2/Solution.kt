package solutions.bestTimeToBuyAndSellStock2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(122, "Best Time to Buy and Sell Stock II", ProblemDifficulty.EASY,
    "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/")
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }

        return profit
    }
}