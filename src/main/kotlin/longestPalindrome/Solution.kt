package longestPalindrome

class Solution {
    fun longestPalindrome(s: String): String {
        var maxLength = 1
        var start = 0

        val table = Array(s.length) { BooleanArray(s.length) }

        // fill length 1
        for (i in s.indices) {
            table[i][i] = true
        }

        // fill length 2
        for (i in 0 until s.length - 1) {
            if(s[i] == s[i + 1]) {
                table[i][i + 1] = true
                maxLength = 2
                start = i
            }
        }

        // fill length greater than 2
        for (l in 3..s.length) {
            for (i in 0..s.length - l) {
                val j = i + l - 1

                if (table[i + 1][j - 1] && s[i] == s[j]) {
                    table[i][j] = true

                    if(maxLength < l) {
                        maxLength = l
                        start = i
                    }
                }
            }
        }

        return s.substring(start, start + maxLength)
    }
}