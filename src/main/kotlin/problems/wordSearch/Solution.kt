package problems.wordSearch

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(79, "Word Search", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/word-search/")
class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (y in board.indices) {
            for (x in board[y].indices) {
                if (dfs(board, x, y, word, 0))
                    return true
            }

        }
        return false
    }

    private fun dfs(board: Array<CharArray>, x: Int, y: Int, word: String, wIdx: Int): Boolean {
        if (wIdx == word.length) return true
        if (x < 0 || y < 0 || y == board.size || x == board[y].size) return false
        if (word[wIdx] != board[y][x]) return false

        board[y][x] = '#'

        val found = dfs(board, x - 1, y, word, wIdx + 1)
                || dfs(board, x, y - 1, word, wIdx + 1)
                || dfs(board, x + 1, y, word, wIdx + 1)
                || dfs(board, x, y + 1, word, wIdx + 1)

        board[y][x] = word[wIdx]

        return found
    }
}