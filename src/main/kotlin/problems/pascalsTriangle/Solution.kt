package problems.pascalsTriangle

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(118, "Pascal's Triangle", ProblemDifficulty.EASY, "https://leetcode.com/problems/pascals-triangle/")
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        for (row in 0 until  numRows) {
            when(row){
                0 -> res.add(listOf(1))
                1 -> res.add(listOf(1, 1))
                else -> {
                    val temp = mutableListOf(1)
                    temp.addAll(res.last().windowed(2).map { it.sum() })
                    temp.add(1)
                    res.add(temp)
                }
            }
        }

        return res
    }
}