package problems.maximumLengthOfConcatenatedStringWithUniqueCharacters

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    1239,
    "Maximum Length of a Concatenated String with Unique Characters",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/"
)
object Solution {
    fun maxLength(arr: List<String>): Int {
        val uniqueBits = ArrayList<Int>(arr.size)
        for (s in arr) {
            var bitSet = 0
            for (c in s) {
                val charMask = 1 shl (c - 'a')
                if ((bitSet and charMask) == charMask) {
                    bitSet = 0
                    break
                }

                bitSet = bitSet xor charMask
            }

            if (bitSet != 0) uniqueBits.add(bitSet)
        }

        var maxLen = 0
        val acc = mutableListOf(0)
        for (unique in uniqueBits) {
            val size = acc.size
            for (i in 0 until size) {
                if ((unique and acc[i]) == 0) {
                    val new = unique or acc[i]
                    acc.add(new)
                    maxLen = maxOf(maxLen, Integer.bitCount(new))
                }
            }
        }

        return maxLen
    }
}