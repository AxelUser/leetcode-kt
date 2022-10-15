package problems.mergeSortedArray

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(88, "Merge Sorted Array", ProblemDifficulty.EASY, "https://leetcode.com/problems/merge-sorted-array/")
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var ins = m + n - 1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[ins--] = nums1[i--]
            } else {
                nums1[ins--] = nums2[j--]
            }
        }

        while (j >= 0) {
            nums1[ins--] = nums2[j--]
        }
    }
}