package problems.earliestPossibleDayOfFullBloom

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    2136,
    "Earliest Possible Day of Full Bloom",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/earliest-possible-day-of-full-bloom/"
)
object Solution {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
        val idxDescGrow =
            growTime.indices.sortedWith(Comparator<Int> { idx1, idx2 -> growTime[idx2].compareTo(growTime[idx1]) })

        var exceededPlanTime = 0
        var result = 0
        for (i in idxDescGrow) {
            result = maxOf(result, exceededPlanTime + plantTime[i] + growTime[i])
            exceededPlanTime += plantTime[i]
        }

        return result
    }
}