package design.medianFinder

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    295,
    "Find Median from Data Stream",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/find-median-from-data-stream/"
)
class MedianFinder {
    private val smaller = PriorityQueue<Int>(Comparator { a, b -> b - a })
    private val larger = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (smaller.isEmpty() || num <= smaller.peek()) smaller.offer(num)
        else larger.offer(num)
        if (smaller.size > larger.size + 1) larger.offer(smaller.poll())
        else if (larger.size > smaller.size) smaller.offer(larger.poll())
    }

    fun findMedian(): Double {
        val even = (larger.size + smaller.size) % 2 == 0
        return if (even) (larger.peek() + smaller.peek()) / 2.0
        else smaller.peek().toDouble()
    }
}