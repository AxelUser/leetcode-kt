package design.stackOverQueues

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    225,
    "Implement Stack using Queues",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/implement-stack-using-queues/"
)
class MyStack {
    private val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        queue.add(x)
        repeat(queue.size - 1) {
            queue.add(queue.poll())
        }
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}