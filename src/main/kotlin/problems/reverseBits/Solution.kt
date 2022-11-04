package problems.reverseBits

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(190, "Reverse Bits", ProblemDifficulty.EASY, "https://leetcode.com/problems/reverse-bits/")
object Solution {
    fun reverseBits(n: Int): Int {
        var res = n
        res = res and 0x55555555 shl 1 or (res ushr 1 and 0x55555555)
        res = res and 0x33333333 shl 2 or (res ushr 2 and 0x33333333)
        res = res and 0x0f0f0f0f shl 4 or (res ushr 4 and 0x0f0f0f0f)
        res = res shl 24 or (res and 0xff00 shl 8) or
                (res ushr 8 and 0xff00) or (res ushr 24)
        return res
    }
}