package solutions.permutations

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(46, "Permutations", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/permutations/")
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        return mutableListOf<List<Int>>().apply { backtrack(this, nums, LinkedHashSet()) }
    }

    private fun backtrack(result: MutableList<List<Int>>, nums: IntArray, prefix: LinkedHashSet<Int>) {
        if (prefix.size == nums.size) {
            result.add(prefix.toList())
        } else {
            for (n in nums) {
                if (prefix.contains(n)) continue

                prefix.add(n)
                backtrack(result, nums, prefix)
                prefix.remove(n)
            }
        }
    }
}