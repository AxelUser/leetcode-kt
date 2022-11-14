package problems.mostStonesRemovedWithSameRowOrColumn

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    947,
    "Most Stones Removed with Same Row or Column",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/"
)
class Solution {
    private val ufMap = mutableMapOf<Int, Int>()
    private var singles = 0

    fun removeStones(stones: Array<IntArray>): Int {
        for ((x, y) in stones) {
            union(x, y.inv())
        }
        return stones.size - singles
    }

    private fun find(idx: Int): Int {
        return ufMap.compute(idx) { cur, prev ->
            if (prev == null) {
                singles++
                cur
            } else if (cur != prev) {
                find(prev)
            } else prev
        }!!
    }

    private fun union(idx1: Int, idx2: Int) {
        val f1 = find(idx1)
        val f2 = find(idx2)
        if (f1 != f2) {
            ufMap[f1] = f2
            singles--
        }
    }
}