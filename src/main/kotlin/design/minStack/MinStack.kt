package design.minStack

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(155, "Min Stack", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/min-stack/")
class MinStack {
    private val stack = Stack<Pair<Int, Int>>()

    fun push(`val`: Int) {
        val minVal = if (stack.empty()) `val` else minOf(`val`, stack.peek().second)
        stack.push(`val` to minVal)
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }
}