package problems.guessNumberHigherOrLower

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

abstract class GuessGame(var picked: Int = 10) {
    abstract fun guessNumber(n: Int): Int
    fun guess(num: Int): Int = when {
        num > picked -> -1
        num < picked -> 1
        else -> 0
    }
}

@ProblemSolution(
    374,
    "Guess Number Higher or Lower",
    ProblemDifficulty.EASY,
    "https://leetcode.com/problems/guess-number-higher-or-lower/"
)
class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var l = 0
        var r = n
        while (l != r) {
            val mid1 = l + (r - l) / 3
            val mid2 = r - (r - l) / 3
            val guess1 = guess(mid1)
            val guess2 = guess(mid2)
            when {
                guess1 == 0 -> {
                    l = mid1
                    r = mid1
                }

                guess2 == 0 -> {
                    l = mid2
                    r = mid2
                }

                guess1 < 0 -> r = mid1 - 1
                guess2 > 0 -> l = mid2 + 1
                else -> {
                    l = mid1 + 1
                    r = mid2 - 1
                }
            }
        }

        return l
    }
}