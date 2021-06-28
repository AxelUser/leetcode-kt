package solutions.bestTimeToBuyAndSellStock

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(121, "Best Time to Buy and Sell Stock", ProblemDifficulty.EASY,
    "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/")
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            if (price < minPrice) {
                minPrice = price
            } else if (maxProfit < price - minPrice) {
                maxProfit = price - minPrice
            }
        }

        return maxProfit
    }
}