package problems.bestTimeToBuyAndSellStockWithTransactionFee

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    714,
    "Best Time to Buy and Sell Stock with Transaction Fee",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/"
)
class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var profit = -prices[0]
        var balance = 0
        for (i in 1..prices.lastIndex) {
            profit = maxOf(profit, balance - prices[i])
            balance = maxOf(balance, prices[i] + profit - fee)
        }
        return balance
    }
}