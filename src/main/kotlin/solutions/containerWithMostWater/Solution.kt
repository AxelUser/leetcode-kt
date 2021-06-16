package solutions.containerWithMostWater

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(11, "Container With Most Water", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/container-with-most-water/")
class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.lastIndex

        while (left < right) {
            val minHeight = minOf(height[left], height[right])
            val area = minHeight * (right - left)
            max = maxOf(max, area)

            while (left < right) {
                if(minHeight < height[left]) break
                left++
            }

            while (left < right) {
                if(minHeight < height[right]) break
                right--
            }
        }

        return max
    }
}