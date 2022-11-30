package problems.longestRepeatingCharacterReplacement

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(
    424,
    "Longest Repeating Character Replacement",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/longest-repeating-character-replacement/"
)
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var start = 0
        val freq = IntArray(26)
        var maxFreq = 0
        var windowLen = 0
        // move expand window
        for (end in 0..s.lastIndex) {
            val cur = s[end] - 'A'
            freq[cur]++

            // maxFreq stores the global max frequency, not only for window.
            // Even if a new window is not valid, we don't need to decrease it less, than previous max window side.
            // So, we are only increasing window size, or it stays the same. That's why last window size will be the actual
            // maximum of a valid substring.
            maxFreq = maxOf(maxFreq, freq[cur])
            windowLen = end - start + 1

            if (windowLen - maxFreq > k) {
                freq[s[start++] - 'A']--
                windowLen--
            }
        }

        return windowLen
    }
}