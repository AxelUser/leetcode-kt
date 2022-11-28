package design.queueOverStacks

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    232,
    "Implement Queue using Stacks",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/implement-queue-using-stacks/"
)
class MyQueue {
    private var pushStack = Stack<Int>()
    private var popStack = Stack<Int>()

    fun push(x: Int) {
        pushStack.push(x)
    }

    fun pop(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }

        return popStack.pop()
    }

    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }

        return popStack.peek()
    }

    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }
}