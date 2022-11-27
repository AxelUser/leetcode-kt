package problems.findAllAnagramsInAString

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    438,
    "Find All Anagrams in a String",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/find-all-anagrams-in-a-string/"
)
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val pMap = IntArray(26).also {
            for (c in p) it[c - 'a']++
        }
        val k = p.length

        val sMap = IntArray(26)
        val res = mutableListOf<Int>()
        for (i in s.indices) {
            ++sMap[s[i] - 'a']

            if (i > k - 1) {
                --sMap[s[i - k] - 'a']
            }

            if (i >= k - 1) {
                var matched = true
                for (j in pMap.indices) {
                    if (pMap[j] > 0 && sMap[j] < pMap[j]) {
                        matched = false
                        break
                    }
                }

                if (matched) res.add(i - k + 1)
            }
        }

        return res
    }
}