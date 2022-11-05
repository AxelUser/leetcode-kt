package problems.wordSearch2

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(212, "Word Search II", ProblemDifficulty.HARD, "https://leetcode.com/problems/word-search-ii/")
object Solution {
    private class TrieNode(val parent: TrieNode?) {
        private val children = Array<TrieNode?>(26) { null }
        private var refs = 0
        var word: String? = null

        operator fun plus(c: Char): TrieNode {
            if (children[c - 'a'] == null) {
                refs++
                children[c - 'a'] = TrieNode(this)
            }

            return children[c - 'a']!!
        }

        fun remove(): Boolean {
            val rmW = word ?: return false
            word = null
            // if leaf
            if (refs == 0) {
                var cur = parent
                var wIdx = rmW.length - 1
                while (wIdx >= 0 && cur != null) {
                    cur.children[rmW[wIdx--] - 'a'] = null
                    if (--cur.refs > 0) break
                    cur = cur.parent
                }

                return true
            }

            return false
        }

        operator fun get(c: Char): TrieNode? = children[c - 'a']
    }

    private val dirs = arrayOf(0, 1, 0, -1, 0)

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trieHead = TrieNode(null)
        for (w in words) {
            var cur = trieHead
            w.forEach { cur += it }
            cur.word = w
        }

        val res = mutableListOf<String>()
        fun dfs(y: Int, x: Int, node: TrieNode, visited: Array<BooleanArray>) {
            if (y !in board.indices || x !in board[y].indices || visited[y][x]) return

            node[board[y][x]]?.also {
                val stop = it.word?.run {
                    res.add(this)
                    it.remove()
                }

                if (stop != true) {
                    visited[y][x] = true

                    for (i in 1 until dirs.size) {
                        dfs(y + dirs[i - 1], x + dirs[i], it, visited)
                    }

                    visited[y][x] = false
                }
            }
        }

        val visited = Array(board.size) { BooleanArray(board[0].size) }

        board.forEachIndexed { y, row ->
            repeat(row.size) { x ->
                dfs(y, x, trieHead, visited)
            }
        }

        return res
    }
}