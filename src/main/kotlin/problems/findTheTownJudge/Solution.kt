package problems.findTheTownJudge

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    997,
    "Find the Town Judge",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/find-the-town-judge/"
)
object Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustScore = IntArray(n + 1)
        for (t in trust) {
            trustScore[t[0]]--
            trustScore[t[1]]++
        }

        for (i in 1..n) {
            if (trustScore[i] == n - 1) return i
        }

        return -1
    }
}