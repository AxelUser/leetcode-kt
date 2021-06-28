package solutions.trappingRainWater

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(42, "Trapping Rain Water", ProblemDifficulty.HARD,
    "https://leetcode.com/problems/trapping-rain-water/")
class Solution {
    fun trap(height: IntArray): Int {
        val stack = Stack<Int>()
        var trapped = 0

        for (current in height.indices) {
            while (stack.isNotEmpty() && height[current] > height[stack.peek()]) {
                val bounded = stack.pop()!!
                if (stack.isEmpty())
                    break

                val trappedDistance = current - stack.peek() - 1
                val trappedHeight = minOf(height[current], height[stack.peek()]) - height[bounded]
                trapped += trappedDistance * trappedHeight
            }
            stack.push(current)
        }

        return trapped
    }
}