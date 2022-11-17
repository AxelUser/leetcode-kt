package problems.rectangleArea

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(223, "Rectangle Area", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/rectangle-area/")
object Solution {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val areaA = (ax2 - ax1) * (ay2 - ay1)
        val areaB = (bx2 - bx1) * (by2 - by1)

        val overlapX = minOf(ax2, bx2) - maxOf(ax1, bx1)
        val overlapY = minOf(ay2, by2) - maxOf(ay1, by1)


        val overlapArea = if (overlapX > 0 && overlapY > 0) overlapX * overlapY else 0

        return areaA + areaB - overlapArea
    }
}