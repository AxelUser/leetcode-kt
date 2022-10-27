package problems.imageOverlap

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(835, "Image Overlap", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/image-overlap/")
object Solution {
    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val n = img1.size
        val extendedImg2 = Array(3 * n - 2) { IntArray(3 * n - 2) }
        for (y in 0 until n) {
            for (x in 0 until n) {
                extendedImg2[y + n - 1][x + n - 1] = img2[y][x]
            }
        }

        val maxShift = 2 * n - 1
        var maxOverlaps = 0
        for (yShift in 0 until maxShift) {
            for (xShift in 0 until maxShift) {
                maxOverlaps = maxOf(maxOverlaps, convolute(img1, extendedImg2, yShift, xShift))
            }
        }

        return maxOverlaps
    }

    private fun convolute(img: Array<IntArray>, extended: Array<IntArray>, yShift: Int, xShift: Int): Int {
        var result = 0

        for (y in img.indices) {
            for (x in img.indices) {
                result += img[y][x] and extended[y + yShift][x + xShift]
            }
        }

        return result
    }
}