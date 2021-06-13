package regularExpressionMatching

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val memo = Array<Array<Boolean?>>(s.length + 1) { Array(p.length + 1) { null } }
        return dfs(0, 0, s, p, memo)
    }

    // Top-Down DP solution
    private fun dfs(sIdx: Int, pIdx: Int, s: String, p: String, memo: Array<Array<Boolean?>>): Boolean {
        if (memo[sIdx][pIdx] == true) return true

        // string and pattern finished
        if(sIdx >= s.length && pIdx >= p.length) return true

        // have unmatched chars in string
        if(pIdx >= p.length) return false

        // chars matches or there's a dot in pattern
        val currentMatch = sIdx < s.length && (s[sIdx] == p[pIdx] || p[pIdx] == '.')

        // if processing "wildcard"
        if(pIdx + 1 < p.length && p[pIdx + 1] == '*') {
            val wildcardMatch = dfs(sIdx, pIdx + 2, s, p, memo) // wildcard as zero chars
                    || currentMatch && dfs(sIdx + 1, pIdx, s, p, memo) // wildcard as char
            memo[sIdx][pIdx] = wildcardMatch

            return wildcardMatch
        }

        // regular char match
        if(currentMatch) {
            val m = dfs(sIdx + 1, pIdx + 1, s, p, memo)
            memo[sIdx][pIdx] = m
            return m
        }

        // no matches
        memo[sIdx][pIdx] = false
        return false
    }
}