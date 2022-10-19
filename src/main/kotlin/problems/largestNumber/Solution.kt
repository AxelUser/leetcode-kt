package problems.largestNumber

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(179, "Largest Number", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/largest-number/")
object Solution {
    fun largestNumber(nums: IntArray): String {
        val sNums = nums.map { it.toString() }
        val sorted = sNums.sortedWith(Comparator({ a: String, b: String -> (b + a).compareTo(a + b) }))
        return sorted.reduce { acc, s -> if (acc == "0") s else acc + s }
    }
}