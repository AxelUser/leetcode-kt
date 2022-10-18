package problems.topKFrequentElements

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    347,
    "Top K Frequent Elements",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/top-k-frequent-elements/"
)
object Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = HashMap<Int, Int>()
        for (n in nums) {
            if (freqMap.computeIfPresent(n) { _, v -> v + 1 } == null) {
                freqMap[n] = 1
            }
        }

        val freqBuckets = Array<LinkedList<Int>?>(nums.size + 1) { null }
        for ((n, f) in freqMap) {
            if (freqBuckets[f]?.add(n) != true) {
                freqBuckets[f] = LinkedList<Int>().also { it.add(n) }
            }
        }

        val res = IntArray(k)
        var i = 0
        var bi = freqBuckets.lastIndex
        while (i < res.size) {
            if (freqBuckets[bi]?.isEmpty() == false) {
                res[i++] = freqBuckets[bi]!!.remove()
            } else {
                bi--
            }
        }

        return res
    }
}