package problems.groupAnagrams

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(49, "Group Anagrams", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/group-anagrams/")
object Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { getHash(it) }.values.toList()
    }

    private fun getHash(str: String): String {
        val counted = IntArray(26)
        for (c in str) {
            counted[c - 'a']++
        }

        return buildString {
            for (i in counted.indices) {
                if (counted[i] > 0) {
                    append("${i}:${counted[i]};")
                }
            }
        }
    }
}