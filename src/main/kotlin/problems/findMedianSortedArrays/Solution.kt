package problems.findMedianSortedArrays

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(4, "Median of Two Sorted Arrays", ProblemDifficulty.HARD,
    "https://leetcode.com/problems/median-of-two-sorted-arrays/")
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = mutableListOf<Int>()
        var idx1 = 0
        var idx2 = 0

        while (idx1 < nums1.size || idx2 < nums2.size) {
            val first = if (idx1 < nums1.size) nums1[idx1] else null
            val second = if (idx2 < nums2.size) nums2[idx2] else null

            when{
                first == null -> {
                    merged.add(second!!)
                    idx2++
                }
                second == null -> {
                    merged.add(first)
                    idx1++
                }
                first <= second -> {
                    merged.add(first)
                    idx1++
                }
                second < first -> {
                    merged.add(second)
                    idx2++
                }
            }
        }

        return if (merged.size % 2 == 0) {
            (merged[merged.size / 2 - 1] + merged[merged.size / 2]) / 2.0
        } else {
            merged[merged.size / 2].toDouble()
        }
    }
}