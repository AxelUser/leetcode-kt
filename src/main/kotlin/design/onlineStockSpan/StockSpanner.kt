package design.onlineStockSpan

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(901, "Online Stock Span", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/online-stock-span/")
class StockSpanner {
    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var days = 1
        while (stack.isNotEmpty() && stack.peek().first <= price) days += stack.pop().second

        stack.push(price to days)

        return days
    }
}