package problems.topKFrequentWords

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    692,
    "Top K Frequent Words",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/top-k-frequent-words/"
)
object Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freqMap = HashMap<String, Int>()
        for (n in words) {
            if (freqMap.computeIfPresent(n) { _, v -> v + 1 } == null) {
                freqMap[n] = 1
            }
        }

        val freqBuckets = Array<ArrayList<String>>(words.size + 1) { ArrayList() }
        for ((n, f) in freqMap) {
            freqBuckets[f].insSortDesc(n)
        }

        val res = ArrayList<String>(k)
        var bi = freqBuckets.lastIndex
        while (res.size < k) {
            if (freqBuckets[bi].isNotEmpty()) {
                res.add(freqBuckets[bi].removeAt(freqBuckets[bi].size - 1))
            } else {
                bi--
            }
        }

        return res
    }

    private fun ArrayList<String>.insSortDesc(new: String) {
        add(new)
        var i = size - 1
        var temp: String
        while (i > 0 && this[i - 1] < this[i]) {
            temp = this[i]
            this[i] = this[i - 1]
            this[i - 1] = temp
            i--
        }
    }
}