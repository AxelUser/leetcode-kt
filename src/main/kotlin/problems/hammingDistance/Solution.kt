package problems.hammingDistance

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(461, "Hamming Distance", ProblemDifficulty.EASY, "https://leetcode.com/problems/hamming-distance/")
object Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var diffBits = x xor y
        var count = 0
        while (diffBits != 0) {
            count += diffBits and 1
            diffBits = diffBits ushr 1
        }

        return count
    }
}