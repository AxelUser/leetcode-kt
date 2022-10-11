package design.queueOverStacks

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.Stack

@ProblemSolution(
    232,
    "Implement Queue using Stacks",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/implement-queue-using-stacks/"
)
class MyQueue {
    private var stack = Stack<Int>()

    fun push(x: Int) {
        val temp = Stack<Int>()
        while (stack.isNotEmpty()) {
            temp.push(stack.pop())
        }
        temp.push(x)
        while (temp.isNotEmpty()) {
            stack.push(temp.pop())
        }
    }

    fun pop(): Int {
        return stack.pop()
    }

    fun peek(): Int {
        return stack.peek()
    }

    fun empty(): Boolean {
        return stack.empty()
    }
}